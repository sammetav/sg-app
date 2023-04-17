package com.core.sgapp.dto

import com.core.sgapp.entities.Gender
import com.core.sgapp.entities.School
import com.core.sgapp.entities.Student
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class StudentDto(
    val id: Long? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val gender: Gender? = null,
    val school: School
) {
    //constructor(firstName: String?, lastName: String?, school: School) : this(null, firstName, lastName, school)

    @JsonCreator
    fun fromJson(
        @JsonProperty("id") id: Long?,
        @JsonProperty("firstName") firstName: String?,
        @JsonProperty("lastName") lastName: String?,
        @JsonProperty("gender") gender: Gender?,
        @JsonProperty("school") school: School,
    ): StudentDto =
        StudentDto(
            id = id,
            firstName = firstName,
            lastName = lastName,
            gender = gender,
            school = school,
        )

    fun toEntity(): Student {
        return Student(
            firstName = this.firstName,
            lastName = this.lastName,
            gender = this.gender,
            school = this.school,
        )
    }
}
