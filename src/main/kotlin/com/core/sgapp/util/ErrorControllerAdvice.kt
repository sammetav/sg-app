package com.core.sgapp.util

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ErrorControllerAdvice {

    @ExceptionHandler(EntityNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    fun handleEntityNotFoundException(ex: EntityNotFoundException): ErrorResponse? {
        return ex.message?.let { ErrorResponse(HttpStatus.NOT_FOUND.value(), it) }
    }

    data class ErrorResponse(val status: Int, val message: String)
}
