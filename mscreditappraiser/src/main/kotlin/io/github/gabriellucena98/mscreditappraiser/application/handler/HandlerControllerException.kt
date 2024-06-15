package io.github.gabriellucena98.mscreditappraiser.application.handler

import feign.FeignException
import io.github.gabriellucena98.mscreditappraiser.application.ex.ClientDataNotFoundException
import io.github.gabriellucena98.mscreditappraiser.application.ex.ErrorRequestCardException
import io.github.gabriellucena98.mscreditappraiser.application.ex.GenericMicroservicesException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class HandlerControllerException: ResponseEntityExceptionHandler() {

    @ResponseBody
    @ExceptionHandler(ClientDataNotFoundException::class)
    fun handlerClientDataNotFoundException(ex: ClientDataNotFoundException, request: WebRequest): ResponseEntity<Error> {
        return ResponseEntity(Error(
            message = ex.message!!,
            http = 404,
            code = "error.request.client-not-found"
        ), HttpStatus.NOT_FOUND)
    }

    @ResponseBody
    @ExceptionHandler(Exception::class)
    fun handlerGenericMicroserviceException(ex: Exception, request: WebRequest): ResponseEntity<Error> {
        return ResponseEntity(Error(
            message = ex.message!!,
            http = 500,
            code = "error.request.microservice-problem"
        ), HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ResponseBody
    @ExceptionHandler(ErrorRequestCardException::class)
    fun handlerErrorRequestCardException(ex: ErrorRequestCardException, request: WebRequest): ResponseEntity<Error> {
        return ResponseEntity(Error(
            message = ex.message!!,
            http = 500,
            code = "error.request.rabbitMQ-problem"
        ), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}