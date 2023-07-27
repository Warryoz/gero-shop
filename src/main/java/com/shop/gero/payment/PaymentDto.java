package com.shop.gero.payment;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {
    private Long id;
    @NotEmpty
    private String type;
    @NotEmpty
    private String cardholderName;
    @NotEmpty
    private String cardNumber;
    @NotEmpty
    private int expiryYear;
    @NotEmpty
    private int expiryMonth;
    @Size(min = 3, max = 4)
    private int cvc;
    private Long orderId;
}
