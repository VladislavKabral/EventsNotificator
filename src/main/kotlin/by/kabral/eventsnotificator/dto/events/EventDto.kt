package by.kabral.eventsnotificator.dto.events

import java.time.LocalDate
import java.util.*

data class EventDto(
  val id: UUID?,
  val name: String?,
  val description: String?,
  val date: LocalDate,
  val type: EventTypeDto,
)