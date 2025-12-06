package by.kabral.eventsnotificator.service

import by.kabral.eventsnotificator.dto.PersonDto
import by.kabral.eventsnotificator.mapper.PeopleMapper
import by.kabral.eventsnotificator.model.Person
import by.kabral.eventsnotificator.repository.PeopleRepository
import by.kabral.eventsnotificator.util.Message.PERSON_NOT_FOUND
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PeopleService(
  private val peopleRepository: PeopleRepository,
  private val peopleMapper: PeopleMapper
) {

  fun getPeopleDto(): List<PersonDto> {
    return peopleRepository
      .findAll()
      .map { peopleMapper.toDto(it) }
  }

  fun findById(id: UUID): Person {
    return peopleRepository.findById(id)
      .orElseThrow { EntityNotFoundException(String.format(PERSON_NOT_FOUND, id)) }
  }

  fun getPersonDtoById(id: UUID): PersonDto {
    return peopleRepository.findById(id)
      .map { peopleMapper.toDto(it) }
      .orElseThrow { EntityNotFoundException(String.format(PERSON_NOT_FOUND, id)) }
  }
}