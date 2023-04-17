package com.core.sgapp.entities

import jakarta.persistence.*

@Entity
@Table(name = "school")
class School(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String? = null,
    var city: String? = null,
    var state: String? = null,
    var active: Boolean? = false
) : BaseEntity() {
}
