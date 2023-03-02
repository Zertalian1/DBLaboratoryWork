package com.example.dblaboratorywork.controller


import com.example.dblaboratorywork.dto.WorkerRegistrationDto
import com.example.dblaboratorywork.enums.Post
import com.example.dblaboratorywork.enums.Role
import com.example.dblaboratorywork.service.UserService
import com.example.dblaboratorywork.service.WorkerService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class CreateWorkerController(
    val workerService: WorkerService,
    val userService: UserService
    ) {

    @GetMapping("/newWorker")
    fun getCreateNewWorkerPage(@ModelAttribute("workerDto") worker : WorkerRegistrationDto) : String{
        println("hi")
        return "pages/CreateNewWorker";
    }
    @PostMapping("/newWorker")
    fun createNewWorker(@ModelAttribute("workerDto") worker : WorkerRegistrationDto) : String{
        /*when(worker.worker.post){
            Post.WORKER -> worker.user.roles=Role.ROLE_WORKER
            Post.ADMIN -> worker.user.roles=Role.ROLE_ADMIN
            Post.MANAGER -> worker.user.roles=Role.ROLE_MANAGER
            Post.DIRECTOR -> worker.user.roles=Role.ROLE_DIRECTOR
        }*/
        /*worker.user.roles=Role.valueOf("ROLE_"+worker.worker.post.toString())
        userService.addUser(worker.user)
        worker.worker.userId=worker.user.id
        println(worker.user.id)
        workerService.addWorker(worker.worker)*/
        return "redirect:/newWorker";
    }
}