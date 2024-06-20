package com.framework.service;

import com.framework.entity.Account;
import com.framework.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountByMemberId(Long memberId) {
        return accountRepository.findByMemberId(memberId);
    }

    public Account rechargeAccount(Long memberId, double amount) {
        Account account = accountRepository.findByMemberId(memberId);
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }
}
