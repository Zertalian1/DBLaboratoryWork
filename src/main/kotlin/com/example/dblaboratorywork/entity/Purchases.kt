package com.example.dblaboratorywork.entity

import com.example.dblaboratorywork.entity.product.Product
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Table("purchases")
class Purchases(
    @Id
    var id: Long = 0,
    var pointOfSale: PointOfSale,
    var product: Product,
    var price: BigDecimal,
    var quantity: Float,
    var dateOfSale: LocalDateTime
)