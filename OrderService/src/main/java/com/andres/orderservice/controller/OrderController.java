package com.andres.orderservice.controller;

import com.andres.orderservice.dto.OrderRequest;
import com.andres.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        service.placeOrder(orderRequest);
        return "Order placed successfully";
    }
}
