package com.framework.merchant.job;

import com.framework.merchant.repository.ProductRepository;
import com.framework.user.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReconciliationJob {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Scheduled(cron = "0 0 0 * * ?")
    public void reconcile() {
        // Reconciliation logic
    }
}
