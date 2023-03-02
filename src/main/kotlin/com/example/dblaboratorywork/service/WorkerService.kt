package com.example.dblaboratorywork.service

import com.example.dblaboratorywork.entity.Worker
import com.example.dblaboratorywork.exception.WorkerNotFound
import com.example.dblaboratorywork.repository.WorkerRepo
import org.springframework.stereotype.Service

@Service
class WorkerService(val workerRepo: WorkerRepo) {

    fun addWorker(worker: Worker){
        workerRepo.save(worker)
    }

    fun findWorkerByUserId(id : Long) : Worker{
        return workerRepo.findWorkerByUserId(id)?:throw WorkerNotFound()
    }
}