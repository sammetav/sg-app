package com.core.sgapp.config.id

import java.util.UUID

class SchoolId(private val value: UUID) {
    override fun toString(): String = value.toString()

    companion object {
        fun generate(): SchoolId = SchoolId(UUID.randomUUID())
        fun fromString(id: String): SchoolId = SchoolId(UUID.fromString(id))
    }
}
