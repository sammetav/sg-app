package com.core.sgapp.entities

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "school")
class School(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,
    var name: String? = null,
    var city: String? = null,
    var state: String? = null,
    var active: Boolean? = false
) : BaseEntity() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is School) return false
        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
