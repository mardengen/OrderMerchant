package com.framework.repository;

import com.framework.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@author: Joshma
 *@date: 2024-06-12
 *@desc:
 */

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m WHERE SIZE(m.orders) > :orderCount")
    List<Member> findMembersWithOrderCountGreaterThan(@Param("orderCount") int orderCount);

}
