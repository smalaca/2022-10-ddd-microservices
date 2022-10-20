package com.smalaca.onlineshop.command.application.offer;

import com.smalaca.onlineshop.command.domain.offer.Offer;
import com.smalaca.onlineshop.command.domain.offer.OfferRepository;
import com.smalaca.onlineshop.command.domain.order.Order;
import com.smalaca.onlineshop.command.domain.order.OrderRepository;
import com.smalaca.onlineshop.command.domain.paymentmethod.PaymentMethod;
import com.smalaca.onlineshop.command.domain.paymentmethod.PaymentMethodFactory;

public class OfferCommandFacade {
    private final OfferRepository offerRepository;
    private final OrderRepository orderRepository;
    private final PaymentMethodFactory paymentMethodFactory;

    public OfferCommandFacade(OfferRepository offerRepository, OrderRepository orderRepository, PaymentMethodFactory paymentMethodFactory) {
        this.offerRepository = offerRepository;
        this.orderRepository = orderRepository;
        this.paymentMethodFactory = paymentMethodFactory;
    }

    public void accept(AcceptOfferCommand command) {
        // 0 ... * - data transformation
        Offer offer = offerRepository.findBy(command.getOfferId());
        PaymentMethod paymentMethod = paymentMethodFactory.create(command.getPaymentMethod(), offer.getSellerId());

        // 1 -> kontakt z domeną
        Order order = offer.accept(paymentMethod);

        // 0 ... * - zapisanie zmian
        orderRepository.save(order);
    }
}
