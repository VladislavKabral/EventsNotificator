package by.kabral.eventsnotificator.dto.events

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class EventTypeDto(
  @param:JsonProperty(access = JsonProperty.Access.READ_ONLY)
  val id: UUID?,
  val name: String?,
  val description: String?
)
