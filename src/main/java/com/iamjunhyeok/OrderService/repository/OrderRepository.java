package com.iamjunhyeok.OrderService.repository;

import com.iamjunhyeok.OrderService.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
