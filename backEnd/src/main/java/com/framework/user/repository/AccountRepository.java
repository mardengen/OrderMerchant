package com.framework.user.repository;

import com.framework.user.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByMemberId(Long memberId);
}
