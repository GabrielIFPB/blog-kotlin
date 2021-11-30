package com.inteligenciadigital.blogkotlin.extensions

import java.text.Normalizer
import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
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


fun LocalDateTime.format() = this.format(englishDateFormatter)

private val daysLookup = (1..31).associate { it.toLong() to getOrdinal(it) }

private val englishDateFormatter = DateTimeFormatterBuilder()
	.appendPattern("yyyy-MM-dd")
	.appendLiteral(" ")
	.appendText(ChronoField.DAY_OF_MONTH, daysLookup)
	.appendLiteral(" ")
	.appendPattern("yyyy")
	.toFormatter(Locale.ENGLISH)

private fun getOrdinal(n: Int) = when {
	n in 11..13 -> "${n}th"
	n % 10 == 1 -> "${n}st"
	n % 10 == 2 -> "${n}nd"
	n % 10 == 3 -> "${n}rd"
	else -> "${n}th"
}