package com.example.dblaboratorywork.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import java.security.Principal

@Controller
class ClientPagesController {

    @GetMapping("/purchases")
    fun getPurchases(principal: Principal){

    }
}