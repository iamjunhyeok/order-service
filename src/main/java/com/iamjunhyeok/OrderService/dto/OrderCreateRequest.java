package com.iamjunhyeok.OrderService.dto;

import com.iamjunhyeok.OrderService.constant.PaymentMode;
import lombok.Data;

@Data
public class OrderCreateRequest {

    private Long productId;
    private int totalAmount;
    private int quantity;
    private PaymentMode paymentMode;
}
