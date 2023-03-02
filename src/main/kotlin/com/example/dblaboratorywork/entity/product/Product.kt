package com.example.dblaboratorywork.entity.product

import com.example.dblaboratorywork.enums.ProductType
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("products")
class Product(
    @Id
    var id: Long = 0,
    var name: String,
    var productType: ProductType
)