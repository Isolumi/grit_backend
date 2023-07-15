package net.loobo.grit;

import jakarta.annotation.Resource;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5173/")
@RestController
public class TmfTransactionController {

    @Resource
    TmfTransactionRepository tmfTransactionRepository;

    @Resource
    TmfTransactionService tmfTransactionService;

    @GetMapping("/getTmfTransactions")
    public Page<TmfTransaction> getTmfTransactionPage(@RequestParam(name = "page", required = true) int page,
                                                      @RequestParam(name = "query", required = false) Long query) {

        Pageable pageElements = PageRequest.of(page, 10);
        if (query == null) {
            return tmfTransactionRepository.findByOrderByCreateTs(pageElements);
        } else {
            return tmfTransactionRepository.findByBillingAccountNumOrderByCreateTs(query, pageElements);
        }
    }

    @GetMapping("/getFilteredTmfTransactions")
    public Page<TmfTransaction> getFilteredTmfTransactions(@RequestParam(name = "page", required = true) int page,
                                           @RequestParam(name = "statusCode", required = false) List<String> statusCode,
                                           @RequestParam(name = "activityCode", required = false) List<String> activityCode) {

        return tmfTransactionService.filteredQuery(page, statusCode, activityCode);
    }

    @GetMapping("/getBAN")
    public Page<TmfTransaction> getBan(@RequestParam(name = "page", required = true) int page,
                                       @RequestParam(name = "id", required = true) Long id) {

        Pageable pageElements = PageRequest.of(page, 10);
        return tmfTransactionRepository.findByBillingAccountNumOrderByCreateTs(id, pageElements);
    }
}
