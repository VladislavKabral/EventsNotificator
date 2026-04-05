package by.kabral.eventsnotificator.mapper

import by.kabral.eventsnotificator.dto.events.EventTypeDto
import by.kabral.eventsnotificator.model.EventType
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface EventTypesMapper {
  fun toDto(entity: EventType): EventTypeDto

  @Mapping(target = "id", ignore = true)
  fun toEntity(dto: EventTypeDto): EventType
}