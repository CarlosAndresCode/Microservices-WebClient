package com.andres.orderservice.repository;

import com.andres.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
