package com.example.dblaboratorywork.repository

import com.example.dblaboratorywork.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepo : CrudRepository<User, Long> {

    fun findByEmail(email : String): User?

}