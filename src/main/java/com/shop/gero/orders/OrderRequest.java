package com.shop.gero.orders;

import com.shop.gero.orders.OrderDto;
import com.shop.gero.payment.Payment;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private OrderDto order;
    private Payment payment;
}
