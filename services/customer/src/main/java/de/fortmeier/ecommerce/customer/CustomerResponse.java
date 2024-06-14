package de.fortmeier.ecommerce.customer;


public record CustomerResponse(
        String id,

        String firstName,

        String lastName,

        String email,

        Address address
) {


}
