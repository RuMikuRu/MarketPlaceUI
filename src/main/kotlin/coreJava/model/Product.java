package org.example.model.dao;

public record Product(
        Integer id,
        String name,
        Float price,
        Integer quantity,
        String description
) {
}
