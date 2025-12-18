package by.kabral.eventsnotificator.mapper

import by.kabral.eventsnotificator.dto.people.PersonDto
import by.kabral.eventsnotificator.model.Person
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface PeopleMapper {
  fun toDto(entity: Person): PersonDto
  fun toEntity(dto: PersonDto): Person
}