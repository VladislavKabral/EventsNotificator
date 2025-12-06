package by.kabral.eventsnotificator.dto

import java.time.LocalDate
import java.util.*

data class UserDto(
  val id: UUID?,
  val lastname: String,
  val firstname: String,
  val email: String,
  val dateOfBirth: LocalDate,
  val subscriptions: MutableList<EventDto> = mutableListOf(),
)
