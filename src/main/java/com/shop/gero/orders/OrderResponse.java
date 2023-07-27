package com.shop.gero.orders;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String orderTrackingNumber;
    private OrderStatus status;
    private String message;
}
