package com.example.dblaboratorywork.service

import com.example.dblaboratorywork.details.UserDetailsImpl
import com.example.dblaboratorywork.entity.User
import com.example.dblaboratorywork.enums.Role
import com.example.dblaboratorywork.exception.UserNotFound
import com.example.dblaboratorywork.exception.WrongEmailPassword
import com.example.dblaboratorywork.repository.UserRepo
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(val userRepo: UserRepo): UserDetailsService {

    fun addUser(user: User){
        userRepo.save(user)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        username?.let{
            val user = userRepo.findByEmail(username)
            return UserDetailsImpl(user?:throw UserNotFound())
        }
        throw WrongEmailPassword()
    }
}