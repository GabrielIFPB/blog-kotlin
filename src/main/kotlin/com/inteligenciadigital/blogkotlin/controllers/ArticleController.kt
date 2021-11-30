package com.inteligenciadigital.blogkotlin.controllers

import com.inteligenciadigital.blogkotlin.models.Article
import com.inteligenciadigital.blogkotlin.repositories.ArticleRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/article")
class ArticleController(private val repository: ArticleRepository) {

	@GetMapping("/")
	fun findAll(): Iterable<Article> = repository.findAllByOrderByAddedAtDesc()

	@GetMapping("/{slug}")
	fun findOne(@PathVariable slug: String): Article = repository
		.findBySlug(slug)
		?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist")
}