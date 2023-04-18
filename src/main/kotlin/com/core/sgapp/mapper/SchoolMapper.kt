package com.core.sgapp.mapper

import com.core.sgapp.dto.SchoolDto
import com.core.sgapp.entities.School
import org.springframework.stereotype.Component

@Component
class SchoolMapper {
    fun toEntity(schoolDto: SchoolDto): School {
        return School(
            name = schoolDto.name,
            city = schoolDto.city,
            state = schoolDto.state,
            active = schoolDto.active
        )
    }

    fun toDto(school: School): SchoolDto {
        return SchoolDto(
            name = school.name,
            city = school.city,
            state = school.state,
            active = school.active
        )
    }
}
