package com.core.sgapp.repository

import com.core.sgapp.entities.School
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SchoolRepository: JpaRepository<School, Long> {
}
