package de.marc.order.order;

import de.marc.order.customer.CustomerClient;
import de.marc.order.exception.BusinessException;
import de.marc.order.orderline.OrderLineRequest;
import de.marc.order.orderline.OrderLineService;
import de.marc.order.product.ProductClient;
import de.marc.order.product.PurchaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;

    public Integer createOrder(OrderRequest request) {
        var customer = customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No Customer exists with provided id:: " + request.customerId()));

        productClient.purchaseProducts(request.products());

        var order = repository.save(mapper.toOrder(request));

        for (PurchaseRequest purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        // todo

        // start payment process

        // send the order confirmation --> notification-ms (kafka)
        return null;
    }
}
