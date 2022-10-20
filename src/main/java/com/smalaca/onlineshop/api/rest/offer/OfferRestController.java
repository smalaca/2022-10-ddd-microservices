package com.smalaca.onlineshop.api.rest.offer;

import com.smalaca.onlineshop.command.application.offer.AcceptOfferCommand;
import com.smalaca.onlineshop.command.application.offer.OfferCommandFacade;

import java.util.UUID;

public class OfferRestController {
    private final OfferCommandFacade offerCommandFacade;

    public OfferRestController(OfferCommandFacade offerCommandFacade) {
        this.offerCommandFacade = offerCommandFacade;
    }

    public void accept(String paymentMethod, UUID offerId) {
        offerCommandFacade.accept(new AcceptOfferCommand(paymentMethod, getBuyerIdFromSession(), offerId));
    }

    private UUID getBuyerIdFromSession() {
        return null;
    }
}
