package com.iamjunhyeok.OrderService.service;

import com.iamjunhyeok.OrderService.domain.Order;
import com.iamjunhyeok.OrderService.dto.OrderCreateRequest;
import com.iamjunhyeok.OrderService.external.client.ProductService;
import com.iamjunhyeok.OrderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final ProductService productService;

    public Long placeOrder(OrderCreateRequest request) {
        // Order Entity -> Save the data with Status Order Created
        // Product Service - Block Products (Reduce the Quantity)
        // Payment Service -> Payments -> Success -> COMPLETE, Else CANCELLED
        log.info("Placing Order Request : {}", request);

        productService.reduceQuantity(request.getProductId(), request.getQuantity());

        log.info("Creating Order with status CREATED");
        Order order = Order.builder()
                .amount(request.getTotalAmount())
                .orderStatus("CREATED")
                .productId(request.getProductId())
                .orderDate(LocalDateTime.now())
                .quantity(request.getQuantity())
                .build();
        orderRepository.save(order);

        log.info("Order Places successfully with Order Id : {}", order.getId());

        return order.getId();
    }
}
