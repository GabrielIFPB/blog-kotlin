package com.inteligenciadigital.blogkotlin.extensions

import java.text.Normalizer
import java.util.*

fun String.toSlug() = lowercase(Locale.getDefault())
	.replace("\n", "")
	.replace("[^a-z\\d\\s]".toRegex(), " ")
	.split(" ")
	.joinToString("-")
	.replace("-+".toRegex(), "-")

fun String.slugify(): String = Normalizer
	.normalize(this, Normalizer.Form.NFD)
	.replace("[^\\w\\s-]".toRegex(), "") // Remove all non-word, non-space or non-dash characters
	.replace('-', ' ') // Replace dashes with spaces
	.trim() // Trim leading/trailing whitespace (including what used to be leading/trailing dashes)
	.replace("\\s+".toRegex(), "-") // Replace whitespace (including newlines and repetitions) with single dashes
	.lowercase(Locale.getDefault()) // Lowercase the final results