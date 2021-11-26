package com.inteligenciadigital.blogkotlin.models

import com.inteligenciadigital.blogkotlin.extensions.toSlug
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Article(
	@Id
	@GeneratedValue
	var id: Long? = null,
	var title: String,
	var headline: String,
	var content: String,
	var slug: String = title.toSlug(),
	var addedAt: LocalDateTime = LocalDateTime.now(),

	@ManyToOne
	var author: User,
)