package com.framework.user.controller;

import com.framework.user.entity.Account;
import com.framework.user.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/{memberId}")
    public Account getAccount(@PathVariable Long memberId) {
        return accountService.getAccountByMemberId(memberId);
    }

    @PostMapping("/recharge")
    public Account rechargeAccount(@RequestParam Long memberId, @RequestParam double amount) {
        return accountService.rechargeAccount(memberId, amount);
    }
}
