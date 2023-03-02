package com.example.dblaboratorywork.entity

import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate


@Table("customers")
class Customer(
    val phoneNumber : String,
    firstName: String,
    lastName: String,
    dateOfBirth: LocalDate
) : Person(firstName=firstName, lastName=lastName, dateOfBirth=dateOfBirth)