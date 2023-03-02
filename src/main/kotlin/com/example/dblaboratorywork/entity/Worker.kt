package com.example.dblaboratorywork.entity

import com.example.dblaboratorywork.enums.Post
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDate

@Table("workers")
class Worker(
    var salary: BigDecimal,
    var post : Post,
    var userId : Long,
    firstName: String,
    lastName: String,
    dateOfBirth: LocalDate
) : Person(firstName=firstName, lastName=lastName, dateOfBirth=dateOfBirth)