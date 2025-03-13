package org.example.model.dao;

public record OrderHistory(
        Integer id,
        String orderDate,
        Float LocalPrice
) {
}
