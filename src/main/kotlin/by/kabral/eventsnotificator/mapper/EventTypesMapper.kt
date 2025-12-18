package by.kabral.eventsnotificator.mapper

import by.kabral.eventsnotificator.dto.events.EventTypeDto
import by.kabral.eventsnotificator.model.EventType
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface EventTypesMapper {
  fun toDto(entity: EventType): EventTypeDto
  fun toEntity(dto: EventTypeDto): EventType
}