package net.loobo.grit;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@CrossOrigin(origins = "http://127.0.0.1:5173/")
@RestController
public class TmfTransactionController {

    @Autowired
    TmfTransactionRepository tmfTransactionRepository;

    @GetMapping("/getTmfTransactions")
    public Page<TmfTransaction> getTmfTransactionPage(@RequestParam(name = "page", required = true) int page) {
        Pageable pageElements = PageRequest.of(page, 10);
        return tmfTransactionRepository.findAll(pageElements);
    }

    @GetMapping("/getByQuery")
    public Page<TmfTransaction> getByQuery(@RequestParam(name = "query", required = true) Long query,
                                           @RequestParam(name = "page", required = true) int page) {
        Pageable pageElements = PageRequest.of(page, 10);
        return tmfTransactionRepository.findByBillingAccountNum(query, pageElements);
    }
}
