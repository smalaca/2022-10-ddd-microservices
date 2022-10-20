package com.smalaca.onlineshop.command.domain.offer;

import com.smalaca.onlineshop.command.domain.order.Order;
import com.smalaca.onlineshop.command.domain.paymentmethod.PaymentMethod;
import com.smalaca.onlineshop.command.domain.price.Price;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.Collection;
import java.util.UUID;

public class Offer extends AbstractAggregateRoot<Offer> {
    private final Price price;
    private final UUID sellerId;
    private final Collection<UUID> products;

    public Offer(Price price, UUID sellerId, Collection<UUID> products) {
        this.price = price;
        this.sellerId = sellerId;
        this.products = products;
    }

    public Order accept(PaymentMethod paymentMethod) {
        Order order = new Order(price, sellerId, products);
        andEvent(new OrderCreated(paymentMethod));

        return order;
    }

    public UUID getSellerId() {
        return null;
    }
}
