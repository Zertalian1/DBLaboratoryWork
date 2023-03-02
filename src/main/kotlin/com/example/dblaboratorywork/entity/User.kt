package com.example.dblaboratorywork.entity

import com.example.dblaboratorywork.enums.Role
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("users")
data class User(
    val email: String,
    val password: String,
    val roles: Role,
    @Id
    var id: Long = 0
)