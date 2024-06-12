package com.framework.repository;

import com.framework.entity.Member;
import com.framework.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 *@author: Joshma
 *@date: 2024-06-12
 *@desc:
 */

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByProductNameContaining(String productName);

    @Query("SELECT o FROM Order o WHERE o.orderDate = :orderDate")
    List<Order> findByOrderDate(@Param("orderDate") LocalDate orderDate);

    @Query("SELECT m FROM Member m JOIN m.orders o GROUP BY m HAVING COUNT(o) > :orderCount")
    List<Member> findMembersWithOrderCountGreaterThan(@Param("orderCount") long orderCount);
}
