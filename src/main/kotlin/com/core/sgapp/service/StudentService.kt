package com.core.sgapp.service

import com.core.sgapp.dto.StudentDto
import com.core.sgapp.entities.Student
import com.core.sgapp.repository.StudentRepository
import com.core.sgapp.util.EntityNotFoundException
import com.core.sgapp.util.UserNotFoundException
import org.springframework.stereotype.Service
import java.util.*


@Service
class StudentService(
    private val studentRepository: StudentRepository,
    private val schoolService: SchoolService,
) {
    fun getAllStudents(): MutableList<Student> {
        return studentRepository.findAll()
    }

    fun createStudent(schoolId: Long, studentDto: StudentDto): Student {
        val student = studentDto.toEntity()
        val school = schoolService.findSchoolById(schoolId)
        student.school = school.orElseThrow { EntityNotFoundException("School not found with ID: $schoolId") }
        return studentRepository.save(student)
    }

    fun updateStudent(id: String, studentDto: StudentDto): Student? {
        return studentRepository.findById(id.toLong())
            .map { student ->
                student.firstName = studentDto.firstName
                student.lastName = studentDto.lastName
                studentRepository.save(student)
            }
            .orElse(null)
    }

    fun deleteStudent(id: String): Optional<Student>? {
        return studentRepository.findById(id.toLong()).map {
            it.active = false
            studentRepository.save(it)
        }
    }

    fun getStudentById(id: String): Student? {
        val user = studentRepository.findById(id.toLong())
        return user.orElseThrow { UserNotFoundException() }
    }

    fun getActiveStudents(active: Boolean?): MutableList<Student> {
        return studentRepository.findAllByActive(active ?: true).toMutableList()
    }
}
