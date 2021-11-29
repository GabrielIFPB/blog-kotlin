package com.inteligenciadigital.blogkotlin.repositories

import com.inteligenciadigital.blogkotlin.models.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository: JpaRepository<Article, Long>  {
	fun findBySlug(slug: String): Article?
	fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}