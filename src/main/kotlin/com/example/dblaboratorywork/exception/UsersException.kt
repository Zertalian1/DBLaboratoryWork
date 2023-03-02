package com.example.dblaboratorywork.exception

sealed class UsersException(message: String, cause: Throwable? = null) : Exception(message, cause)

class BadCredentials : UsersException("Bad credentials")

class WrongEmailPassword : UsersException("Wrong email or password")

class UserNotFound : UsersException("No such user")

class WorkerNotFound : UsersException("No such worker")