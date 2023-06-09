package com.core.sgapp.controller

import com.core.sgapp.dto.StudentDto
import com.core.sgapp.entities.Student
import com.core.sgapp.service.SchoolService
import com.core.sgapp.service.StudentService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/")
class StudentController(
    private val studentService: StudentService,
    private val schoolService: SchoolService,
) {

    @GetMapping("allStudents")
    fun getAllStudents(): MutableList<Student> {
        return studentService.getAllStudents()
    }

    @GetMapping("student/{id}")
    fun getStudentById(@PathVariable id: String): Student? {
        return studentService.getStudentById(id)
    }

    @PostMapping("/{schoolId}/createStudent")
    fun createStudent(
        @PathVariable schoolId: Long,
        @RequestBody studentDto: StudentDto
    ): Student {
        return studentService.createStudent(schoolId, studentDto = studentDto)
    }

    @PutMapping("updateStudent/{id}")
    fun updateStudent(@PathVariable id: String, @RequestBody studentDto: StudentDto): Student? {
        return studentService.updateStudent(id, studentDto)
    }

    @DeleteMapping("deleteStudent/{id}")
    fun updateStudent(@PathVariable id: String): Optional<Student>? {
        return studentService.deleteStudent(id)
    }

    @GetMapping("students")
    fun getStudentsByState(@RequestParam active: Boolean): MutableList<Student> {
        return studentService.getActiveStudents(active)
    }
}
