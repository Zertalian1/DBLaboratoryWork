package com.example.dblaboratorywork.entity.supplier

import com.example.dblaboratorywork.entity.product.Product
import com.example.dblaboratorywork.entity.product.ProductRef
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.MappedCollection
import org.springframework.data.relational.core.mapping.Table

@Table("suppliers")
class Supplier (
    @Id
    var id: Long = 0,
    var name: String,
    @MappedCollection(idColumn = "suppliers_id")
    val products: Set<ProductRef> = hashSetOf()
){
    fun addProducts(product : Product){
        this.products.plus(ProductRef(product.id))
    }
}
