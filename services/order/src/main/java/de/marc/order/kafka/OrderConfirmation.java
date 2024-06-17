package de.marc.order.kafka;

import de.marc.order.customer.CustomerResponse;
import de.marc.order.order.PaymentMethod;
import de.marc.order.product.PurchaseResponse;

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
