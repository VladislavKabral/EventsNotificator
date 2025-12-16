package by.kabral.eventsnotificator.dto

import java.time.ZonedDateTime

data class ErrorDto(
  val message: String,
  val timestamp: ZonedDateTime,
)
