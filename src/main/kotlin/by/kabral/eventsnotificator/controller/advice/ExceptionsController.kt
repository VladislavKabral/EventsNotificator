package by.kabral.eventsnotificator.controller.advice

import by.kabral.eventsnotificator.dto.ErrorDto
import by.kabral.eventsnotificator.exception.BusinessLogicException
import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.ZoneOffset
import java.time.ZonedDateTime

@ControllerAdvice
class ExceptionsController {

  @ExceptionHandler(
    BusinessLogicException::class,
    IllegalArgumentException::class
  )
  fun handleBadRequestStatus(ex: Exception) : ResponseEntity<ErrorDto> {
    return ResponseEntity
      .status(HttpStatus.BAD_REQUEST)
      .body(buildResponseBody(ex))
  }

  @ExceptionHandler(EntityNotFoundException::class)
  fun handleNotFoundStatus(ex: Exception) : ResponseEntity<ErrorDto> {
    return ResponseEntity
      .status(HttpStatus.NOT_FOUND)
      .body(buildResponseBody(ex))
  }

  private fun buildResponseBody(ex: Exception): ErrorDto {
    return ErrorDto(
      message = ex.message!!,
      timestamp = ZonedDateTime.now(ZoneOffset.UTC),
    )
  }
}