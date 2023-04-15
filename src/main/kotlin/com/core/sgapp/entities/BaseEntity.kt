package com.core.sgapp.entities

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import java.time.LocalDateTime


@MappedSuperclass
abstract class BaseEntity {

    @Column(name = "created_at", nullable = false, updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()

    @Column(name = "last_modified_at", nullable = false)
    var lastModifiedAt: LocalDateTime = LocalDateTime.now()

    fun updateTimestamps() {
        this.lastModifiedAt = LocalDateTime.now()
    }
}
