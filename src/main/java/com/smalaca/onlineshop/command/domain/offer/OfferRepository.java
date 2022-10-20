package com.smalaca.onlineshop.command.domain.offer;

import java.util.UUID;

public interface OfferRepository {
    Offer findBy(UUID offerId);
}
