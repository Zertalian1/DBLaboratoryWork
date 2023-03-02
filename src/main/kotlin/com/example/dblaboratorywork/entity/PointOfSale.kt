package com.example.dblaboratorywork.entity

import com.example.dblaboratorywork.enums.ProductType
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal

@Table("points_of_sale")
class PointOfSale (
    @Id
    var id: Long = 0,
    var square: Float,
    var rentPrice: BigDecimal,
    var hallsNum: Int,
    var productType: ProductType
)