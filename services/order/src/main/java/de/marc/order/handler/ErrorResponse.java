package de.marc.order.handler;


import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}
