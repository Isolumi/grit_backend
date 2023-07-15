package net.loobo.grit;

import jakarta.annotation.Resource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Service
public class TmfTransactionService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public Page<TmfTransaction> filteredQuery(int page, List<String> statusCode, List<String> activityCode) {
        StringBuilder sql = new StringBuilder("SELECT id, create_ts, service_type, request_body, request_type, " +
                "txn_seq_no, txn_effective_ts, billing_account_num, external_id, subscriber_num, activity_cd, " +
                "override_activity_cd, total_offer, has_shared_offer, distribution_id, created_by, status_cd, " +
                "status_message, retry_times, reason_cd, process_result, processed_by, process_duration, " +
                "last_update_ts, process_by FROM tmf_transaction WHERE ");
        List<String> conditions = new ArrayList<>();

        if (statusCode != null) {
            List<String> sc = new ArrayList<>();
            for (String cd : statusCode) {
                sc.add("'" + cd + "'");
            }
            conditions.add("status_cd IN (" + String.join(",", sc) + ")");
        }
        if (activityCode != null) {
            List<String> ac = new ArrayList<>();
            for (String cd : activityCode) {
                ac.add("'" + cd + "'");
            }
            conditions.add("activity_cd IN (" + String.join(",", ac) + ")");
        }
        sql.append(String.join(" AND ", conditions));
        sql.append(" LIMIT 10 OFFSET ").append(page * 10);
        sql.append(" ORDER BY create_ts ");
        System.out.println(sql.toString());

        List<TmfTransaction> result = jdbcTemplate.query(sql.toString(), (row, rowNum) -> {
            var t = new TmfTransaction();
            t.setId(row.getString(1));
            t.setCreateTs(row.getDate(2));
            t.setServiceType(row.getString(3));
            t.setRequestBody(row.getString(4));
            t.setRequestType(row.getString(5));
            t.setTxnSeqNo(row.getLong(6));
            t.setTxnEffectiveTs(row.getDate(7));
            t.setBillingAccountNum(row.getLong(8));
            t.setExternalId(row.getLong(9));
            t.setSubscriberNum(row.getString(10));
            t.setActivityCd(row.getString(11));
            t.setOverrideActivityCd(row.getString(12));
            t.setTotalOffer(row.getShort(13));
            t.setHasSharedOffer(row.getString(14));
            t.setDistributionId(row.getShort(15));
            t.setCreatedBy(row.getString(16));
            t.setStatusCd(row.getString(17));
            t.setStatusMessage(row.getString(18));
            t.setRetryTimes(row.getShort(19));
            t.setReasonCd(row.getString(20));
            t.setProcessResult(row.getString(21));
            t.setProcessedBy(row.getString(22));
            t.setProcessDuration(row.getInt(23));
            t.setLastUpdateTs(row.getDate(24));
            t.setProcessBy(row.getString(25));
            return t;
        });
        Integer totalElements = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM tmf_transaction WHERE " + String.join(" AND ", conditions), Integer.class);
        int total = (totalElements != null) ? totalElements : 0;

        return new PageImpl<>(result, PageRequest.of(page, 10), total);
    }
}
