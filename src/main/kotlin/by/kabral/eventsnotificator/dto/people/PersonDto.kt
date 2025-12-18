package by.kabral.eventsnotificator.dto.people

import java.util.*

data class PersonDto(
  val id: UUID?,
  val lastname: String?,
  val firstname: String?,
  val middleName: String?
)