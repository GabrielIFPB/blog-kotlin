package com.inteligenciadigital.blogkotlin.repositories

import com.inteligenciadigital.blogkotlin.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
	fun findByLogin(login: String): User?
}