package com.example.dblaboratorywork.repository

import com.example.dblaboratorywork.entity.Worker
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkerRepo : CrudRepository<Worker, Long> {

    fun findWorkerByUserId(userId: Long):Worker?
}