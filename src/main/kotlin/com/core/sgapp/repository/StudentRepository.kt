package com.core.sgapp.repository

import com.core.sgapp.entities.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface StudentRepository : JpaRepository<Student, Long> {

    fun findAllByActive(active: Boolean): List<Student>
}
