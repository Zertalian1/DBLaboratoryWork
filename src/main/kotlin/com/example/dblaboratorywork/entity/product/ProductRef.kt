package com.example.dblaboratorywork.entity.product

import org.springframework.data.relational.core.mapping.Table

@Table("products_suppliers")
class ProductRef(
    val productId : Long
)