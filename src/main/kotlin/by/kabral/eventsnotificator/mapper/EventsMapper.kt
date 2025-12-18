package by.kabral.eventsnotificator.mapper

import by.kabral.eventsnotificator.dto.events.EventDto
import by.kabral.eventsnotificator.model.Event
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface EventsMapper {
  fun toDto(entity: Event): EventDto
  fun toEntity(dto: EventDto): Event
}