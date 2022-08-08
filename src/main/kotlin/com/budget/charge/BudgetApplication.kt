package com.budget.charge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

@SpringBootApplication()
class BudgetApplication

fun main(args: Array<String>) {
	configureApplication(SpringApplicationBuilder()).run(*args)
}

fun configureApplication(builder: SpringApplicationBuilder): SpringApplicationBuilder {
	return builder.sources(BudgetApplication::class.java)
}


