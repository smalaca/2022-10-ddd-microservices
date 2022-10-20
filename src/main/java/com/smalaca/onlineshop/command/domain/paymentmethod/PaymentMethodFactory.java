package com.smalaca.onlineshop.command.domain.paymentmethod;

import java.util.UUID;

public class PaymentMethodFactory {
    private final PaymentService paymentService;

    public PaymentMethodFactory(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public PaymentMethod create(String paymentMethod, UUID sellerId) {
        if (paymentService.isSupportedBy(paymentMethod, sellerId)) {
            return new PaymentMethod(paymentMethod);
        }

        throw new PaymentException(paymentMethod);
    }
}
