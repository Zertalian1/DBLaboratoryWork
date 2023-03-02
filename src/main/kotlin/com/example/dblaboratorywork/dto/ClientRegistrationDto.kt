package com.example.dblaboratorywork.dto

import com.example.dblaboratorywork.entity.Customer
import com.example.dblaboratorywork.entity.User
import com.example.dblaboratorywork.enums.Role
import java.time.LocalDate

class ClientRegistrationDto(
    var email: String? = null,
    var password: String? = null,
    var roles: Role? = null,
    val phoneNumber : String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val dateOfBirth: LocalDate? = null
)