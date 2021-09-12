package com.gft.booktracking

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class BooktrackingApplication

fun main(args: Array<String>) {
	runApplication<BooktrackingApplication>(*args)
}
