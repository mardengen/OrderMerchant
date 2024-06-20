package com.framework.repository;

import com.framework.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByMemberId(Long memberId);
}
