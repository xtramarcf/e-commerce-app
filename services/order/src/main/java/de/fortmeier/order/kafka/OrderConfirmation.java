package de.fortmeier.order.kafka;


import de.fortmeier.order.customer.CustomerResponse;
import de.fortmeier.order.order.PaymentMethod;
import de.fortmeier.order.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
