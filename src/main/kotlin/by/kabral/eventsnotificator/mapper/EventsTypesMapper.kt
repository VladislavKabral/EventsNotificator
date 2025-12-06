package by.kabral.eventsnotificator.mapper

import by.kabral.eventsnotificator.dto.EventTypeDto
import by.kabral.eventsnotificator.model.EventType
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface EventsTypesMapper {
  fun toDto(entity: EventType): EventTypeDto
  fun toEntity(dto: EventTypeDto): EventType
}