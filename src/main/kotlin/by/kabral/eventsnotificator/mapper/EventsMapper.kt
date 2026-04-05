package by.kabral.eventsnotificator.mapper

import by.kabral.eventsnotificator.dto.events.EventDto
import by.kabral.eventsnotificator.model.Event
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface EventsMapper {
  fun toDto(entity: Event): EventDto

  @Mapping(target = "id", ignore = true)
  fun toEntity(dto: EventDto): Event
}