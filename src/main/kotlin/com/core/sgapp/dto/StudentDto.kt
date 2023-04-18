package com.core.sgapp.dto

import com.core.sgapp.entities.Gender
import com.core.sgapp.entities.Student
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class StudentDto(
    val id: Long? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val gender: String? = null,
    val active: Boolean? = null,
) {
    // constructor(firstName: String?, lastName: String?, school: School) : this(null, firstName, lastName, school)

    @JsonCreator
    fun fromJson(
        @JsonProperty("id") id: Long?,
        @JsonProperty("firstName") firstName: String?,
        @JsonProperty("lastName") lastName: String?,
        @JsonProperty("gender") gender: String?,
        @JsonProperty("active") active: Boolean?
    ): StudentDto =
        StudentDto(
            id = id,
            firstName = firstName,
            lastName = lastName,
            gender = gender
        )

    fun toEntity(): Student {
        val student = Student()
        student.firstName = this.firstName
        student.lastName = this.lastName
        student.gender = if (!this.gender.isNullOrEmpty()) Gender.valueOf(this.gender) else null
        student.active = this.active ?: false
        return student
    }
}
