package com.example.dblaboratorywork.entity.supplier

import java.time.LocalDateTime

class Orders(
    var productId : Long,
    var supplierId : Long,
    var managerId : Long,
    var quantity : Int,
    var date : LocalDateTime
)