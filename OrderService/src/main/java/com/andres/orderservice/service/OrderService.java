package com.andres.orderservice.service;

import com.andres.orderservice.dto.OrderLineItemsDTO;
import com.andres.orderservice.dto.OrderRequest;
import com.andres.orderservice.model.Order;
import com.andres.orderservice.model.OrderLineItems;
import com.andres.orderservice.repository.IOrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderService {

    private final IOrderRepository repository;

    public OrderService(IOrderRepository repository) {
        this.repository = repository;
    }

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDTO()
                .stream()
                .map(this::mapToDTO)
                .toList();
//        for (OrderLineItems orderLineItem: orderLineItems){
//            System.out.println(orderLineItem.getSkuCode());
//        }
        order.setOrderLineItems(orderLineItems);
        repository.save(order);
    }

    private OrderLineItems mapToDTO(OrderLineItemsDTO orderLineItemsDTO) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setSkuCode(orderLineItemsDTO.getSkuCode());
        orderLineItems.setPrice(orderLineItemsDTO.getPrice());
        orderLineItems.setQuantity(orderLineItemsDTO.getQuantity());

        return orderLineItems;
    }

}
