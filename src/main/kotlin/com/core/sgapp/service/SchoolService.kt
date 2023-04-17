package com.core.sgapp.service

import com.core.sgapp.dto.SchoolDto
import com.core.sgapp.entities.School
import com.core.sgapp.mapper.SchoolMapper
import com.core.sgapp.repository.SchoolRepository
import com.core.sgapp.util.EntityNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class SchoolService(
    private val schoolRepository: SchoolRepository,
    private val schoolMapper: SchoolMapper,
) {

    fun getAllSchools(): MutableList<School> {
        return schoolRepository.findAll()
    }

    fun findSchoolById(id: Long): Optional<School> {
        return schoolRepository.findById(id)
    }

    fun saveSchool(schoolDto: SchoolDto): School {
        return schoolRepository.save(schoolMapper.toEntity(schoolDto))
    }

    fun updateSchool(schoolId: Long, updatedSchoolDto: SchoolDto): School {
        val existingSchool = checkIfSchoolExists(schoolId)
        existingSchool?.apply {
            name = updatedSchoolDto.name
            city = updatedSchoolDto.city
            state = updatedSchoolDto.state
            active = updatedSchoolDto.active
        }
        return schoolRepository.save(existingSchool!!)
    }

    fun deleteSchool(schoolId: Long) {
        checkIfSchoolExists(schoolId)
        return schoolRepository.deleteById(schoolId)
    }

    private fun checkIfSchoolExists(schoolId: Long): School? = schoolRepository.findById(schoolId)
        .orElseThrow { EntityNotFoundException("School not found with id: $schoolId") }

}
