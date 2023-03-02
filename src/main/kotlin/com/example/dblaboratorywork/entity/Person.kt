package com.example.dblaboratorywork.entity

import org.springframework.data.annotation.Id
import java.time.LocalDate
import java.util.Date


open class Person(
    @Id
    var id: Long = 0,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: LocalDate
)