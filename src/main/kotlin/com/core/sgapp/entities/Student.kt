package com.core.sgapp.entities

import jakarta.persistence.*


@Entity
@Table(name = "student")
class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    @Enumerated(EnumType.STRING)
    var gender: Gender? = null,
    var active: Boolean = true
) : BaseEntity()

enum class Gender {
    MALE, FEMALE
}
