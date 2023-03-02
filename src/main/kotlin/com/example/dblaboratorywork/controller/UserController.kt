package com.example.dblaboratorywork.controller

import com.example.dblaboratorywork.dto.ClientRegistrationDto
import com.example.dblaboratorywork.entity.Customer
import com.example.dblaboratorywork.entity.User
import com.example.dblaboratorywork.enums.Role
import com.example.dblaboratorywork.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import java.time.LocalDate

@Controller
class UserController(val userService : UserService) {

    @GetMapping("/login")
    fun getSignInPage() : String{
        println("hi")
        return "/pages/LoginPage";
    }

    @PostMapping("/login")
    fun signIn() : String{
        return "redirect:/"
    }

    @GetMapping("/registration")
    fun getRegistrationPage(model: Model) : String{
        model.addAttribute("userDto", ClientRegistrationDto())
        return "pages/RegistrationPage";
    }

    @PostMapping("/registration")
    fun registration(userDto : ClientRegistrationDto) : String{
        val user = User(email = userDto.email!!, password = userDto.password!!, roles = Role.ROLE_CLIENT)
        val customer = Customer(phoneNumber = userDto.phoneNumber!!, firstName = userDto.firstName!!, lastName = userDto.lastName!!, dateOfBirth = userDto.dateOfBirth!!)
        return "redirect:/"
    }

}