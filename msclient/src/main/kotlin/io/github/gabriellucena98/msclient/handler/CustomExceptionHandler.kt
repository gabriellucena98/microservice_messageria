package io.github.gabriellucena98.msclient.handler

import jakarta.ws.rs.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class CustomExceptionHandler: ResponseEntityExceptionHandler() {

    @ResponseBody
    @ExceptionHandler(ClassNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(ex: ClassNotFoundException, request: WebRequest): ResponseEntity<Any> {
        return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
    }
}