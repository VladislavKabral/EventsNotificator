package by.kabral.eventsnotificator.dto.users

import by.kabral.eventsnotificator.dto.events.EventDto
import java.time.LocalDate
import java.util.UUID

data class UserDto(
  val id: UUID?,
  val lastname: String?,
  val firstname: String?,
  val email: String?,
  val dateOfBirth: LocalDate?,
  val subscriptions: MutableList<EventDto>? = mutableListOf(),
)