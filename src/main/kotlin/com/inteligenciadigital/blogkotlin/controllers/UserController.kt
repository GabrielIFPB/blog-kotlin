package com.inteligenciadigital.blogkotlin.controllers

import com.inteligenciadigital.blogkotlin.models.User
import com.inteligenciadigital.blogkotlin.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/user")
class UserController(private val repository: UserRepository) {

	@GetMapping("/")
	fun findAll(): MutableList<User> = repository.findAll()

	@GetMapping("/{login}")
	fun findOne(@PathVariable login: String): User = repository
		.findByLogin(login)
		?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist")
}