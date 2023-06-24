package net.loobo.grit;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class TmfTransaction {
    @Id
    private String id;
    private Date createTs;
    private String serviceType;
    private String requestBody;
    private String requestType;
    private Long txnSeqNo;
    private Date txnEffectiveTs;
    private Long billingAccountNum;
    private Long externalId;
    private String subscriberNum;
    private String activityCd;
    private String overrideActivityCd;
    private Short totalOffer;
    private String hasSharedOffer;
    private Short distributionId;
    private String createdBy;
    private String statusCd;
    private String statusMessage;
    private Short retryTimes;
    private String reasonCd;
    private String processResult;
    private String processedBy;
    private Integer processDuration;
    private Date lastUpdateTs;
    private String processBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public Long getTxnSeqNo() {
        return txnSeqNo;
    }

    public void setTxnSeqNo(Long txnSeqNo) {
        this.txnSeqNo = txnSeqNo;
    }

    public Date getTxnEffectiveTs() {
        return txnEffectiveTs;
    }

    public void setTxnEffectiveTs(Date txnEffectiveTs) {
        this.txnEffectiveTs = txnEffectiveTs;
    }

    public Long getBillingAccountNum() {
        return billingAccountNum;
    }

    public void setBillingAccountNum(Long billingAccountNum) {
        this.billingAccountNum = billingAccountNum;
    }

    public Long getExternalId() {
        return externalId;
    }

    public void setExternalId(Long externalId) {
        this.externalId = externalId;
    }

    public String getSubscriberNum() {
        return subscriberNum;
    }

    public void setSubscriberNum(String subscriberNum) {
        this.subscriberNum = subscriberNum;
    }

    public String getActivityCd() {
        return activityCd;
    }

    public void setActivityCd(String activityCd) {
        this.activityCd = activityCd;
    }

    public String getOverrideActivityCd() {
        return overrideActivityCd;
    }

    public void setOverrideActivityCd(String overrideActivityCd) {
        this.overrideActivityCd = overrideActivityCd;
    }

    public Short getTotalOffer() {
        return totalOffer;
    }

    public void setTotalOffer(Short totalOffer) {
        this.totalOffer = totalOffer;
    }

    public String getHasSharedOffer() {
        return hasSharedOffer;
    }

    public void setHasSharedOffer(String hasSharedOffer) {
        this.hasSharedOffer = hasSharedOffer;
    }

    public Short getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(Short distributionId) {
        this.distributionId = distributionId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Short getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(Short retryTimes) {
        this.retryTimes = retryTimes;
    }

    public String getReasonCd() {
        return reasonCd;
    }

    public void setReasonCd(String reasonCd) {
        this.reasonCd = reasonCd;
    }

    public String getProcessResult() {
        return processResult;
    }

    public void setProcessResult(String processResult) {
        this.processResult = processResult;
    }

    public String getProcessBy() {
        return processBy;
    }

    public void setProcessBy(String processBy) {
        this.processBy = processBy;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public Integer getProcessDuration() {
        return processDuration;
    }

    public void setProcessDuration(Integer processDuration) {
        this.processDuration = processDuration;
    }

    public Date getLastUpdateTs() {
        return lastUpdateTs;
    }

    public void setLastUpdateTs(Date lastUpdateTs) {
        this.lastUpdateTs = lastUpdateTs;
    }
}
