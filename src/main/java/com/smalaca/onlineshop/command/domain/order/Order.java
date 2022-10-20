package com.smalaca.onlineshop.command.domain.order;

import com.smalaca.onlineshop.command.domain.price.Price;

import java.util.Collection;
import java.util.UUID;

public class Order {
    private final Price price;
    private final UUID sellerId;
    private final Collection<UUID> products;

    public Order(Price price, UUID sellerId, Collection<UUID> products) {
        this.price = price;
        this.sellerId = sellerId;
        this.products = products;
    }
}
