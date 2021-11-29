package com.inteligenciadigital.blogkotlin

import com.inteligenciadigital.blogkotlin.properties.BlogProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class BlogKotlinApplication

fun main(args: Array<String>) {
	runApplication<BlogKotlinApplication>(*args)
}
