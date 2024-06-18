package de.fortmeier.notification.kafka.order;

public record Customer(
        Integer id,
        String firstName,
        String lastName,
        String email
) {
}
