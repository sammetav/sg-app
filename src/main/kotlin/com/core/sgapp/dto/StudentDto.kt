package com.core.sgapp.dto

import com.core.sgapp.entities.Gender
import com.core.sgapp.entities.Student
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class StudentDto(
    val id: Long? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val gender: Gender? = null,
) {
    constructor(firstName: String?, lastName: String?) : this(null, firstName, lastName)

    @JsonCreator
    fun fromJson(
        @JsonProperty("id") id: Long?,
        @JsonProperty("firstName") firstName: String?,
        @JsonProperty("lastName") lastName: String?,
        @JsonProperty("gender") gender: Gender?,
    ): StudentDto =
        StudentDto(
            id = id,
            firstName = firstName,
            lastName = lastName,
            gender = gender,
        )

    fun toEntity(): Student {
        return Student(
            firstName = this.firstName,
            lastName = this.lastName,
            gender = this.gender
        )
    }
}