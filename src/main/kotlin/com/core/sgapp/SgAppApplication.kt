package com.core.sgapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SgAppApplication

fun main(args: Array<String>) {
    runApplication<SgAppApplication>(*args)
}
