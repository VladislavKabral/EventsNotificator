package by.kabral.eventsnotificator.dto.events

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
import java.util.*

data class EventDto(
  @param:JsonProperty(access = JsonProperty.Access.READ_ONLY)
  val id: UUID?,
  val name: String?,
  val description: String?,
  val date: LocalDate?,
  val type: EventTypeDto,
)