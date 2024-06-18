package de.fortmeier.order.payment;

import de.fortmeier.order.customer.CustomerResponse;
import de.fortmeier.order.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
