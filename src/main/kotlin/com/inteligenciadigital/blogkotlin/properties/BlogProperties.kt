package com.inteligenciadigital.blogkotlin.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding


@ConstructorBinding
@ConfigurationProperties(prefix = "blog")
data class BlogProperties(var title: String, val banner: Banner) {
	data class Banner(val title: String? = null, val content: String)
}