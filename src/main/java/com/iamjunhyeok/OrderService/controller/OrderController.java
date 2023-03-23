package com.iamjunhyeok.OrderService.controller;

import com.iamjunhyeok.OrderService.dto.OrderCreateRequest;
import com.iamjunhyeok.OrderService.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/orders")
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Long> placeOrder(@RequestBody OrderCreateRequest request) {
        Long orderId = orderService.placeOrder(request);
        log.info("Order Id : {}", orderId);
        return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }
}
