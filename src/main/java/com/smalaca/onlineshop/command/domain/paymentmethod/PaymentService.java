package com.smalaca.onlineshop.command.domain.paymentmethod;

import java.util.UUID;

public interface PaymentService {
    boolean isSupportedBy(String paymentMethod, UUID sellerId);
}
