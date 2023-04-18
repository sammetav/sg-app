package com.core.sgapp.controller

import com.core.sgapp.dto.SchoolDto
import com.core.sgapp.entities.School
import com.core.sgapp.service.SchoolService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/schools")
class SchoolController(
    private val schoolService: SchoolService
) {
    @GetMapping
    fun getAllSchools(): MutableList<School> {
        return schoolService.getAllSchools()
    }

    @GetMapping("/{id}")
    fun findSchoolById(@PathVariable id: Long): Optional<School> {
        return schoolService.findSchoolById(id)
    }

    @PostMapping
    fun saveSchool(@RequestBody schoolDto: SchoolDto): School {
        return schoolService.saveSchool(schoolDto)
    }

    @PutMapping("/{schoolId}")
    fun updateSchool(@PathVariable schoolId: Long, @RequestBody updatedSchoolDto: SchoolDto): School {
        return schoolService.updateSchool(schoolId, updatedSchoolDto)
    }

    @DeleteMapping("/{schoolId}")
    fun deleteSchool(@PathVariable schoolId: Long) {
        schoolService.deleteSchool(schoolId)
    }
}
