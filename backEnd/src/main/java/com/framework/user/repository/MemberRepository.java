package com.framework.user.repository;

import com.framework.user.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m WHERE SIZE(m.orders) > :orderCount")
    List<Member> findMembersWithOrderCountGreaterThan(@Param("orderCount") int orderCount);
}
