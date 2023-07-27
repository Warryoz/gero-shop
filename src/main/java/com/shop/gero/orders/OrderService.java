package com.shop.gero.orders;


import com.shop.gero.exceptions.NotPaymentTypeAvailable;
import com.shop.gero.payment.Payment;
import com.shop.gero.payment.PaymentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest){

        final var orderTracking = UUID.randomUUID().toString();
        Order order = modelMapper.map(orderRequest.getOrder(), Order.class);
        order.setStatus(OrderStatus.IN_PROGRESS);
        order.setOrderTracking(orderTracking);
        orderRepository.save(order);

        Payment payment = modelMapper.map(orderRequest.getPayment(), Payment.class);

        if(!payment.getType().equals("CASH")){
                throw new NotPaymentTypeAvailable("Payment type not available");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);
        var count  = paymentRepository.existsById(1L);
        OrderResponse orderResponse = OrderResponse
                .builder()
                .orderTrackingNumber(orderTracking)
                .status(order.getStatus())
                .message("Order placed successfully")
                .build();

        return orderResponse;

    }

}
