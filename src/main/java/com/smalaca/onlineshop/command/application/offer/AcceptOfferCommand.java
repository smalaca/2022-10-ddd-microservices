package com.smalaca.onlineshop.command.application.offer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class AcceptOfferCommand {
    private final String paymentMethod;
    private final UUID buyerId;
    private final UUID offerId;
}
