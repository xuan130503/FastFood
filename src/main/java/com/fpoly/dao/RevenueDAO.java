package com.fpoly.dao;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.entity.Order;

@Repository
public interface RevenueDAO extends JpaRepository<Order, Long> {

	List<Order> findByCreateDateBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);
}