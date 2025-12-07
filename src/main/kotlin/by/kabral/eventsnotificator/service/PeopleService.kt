package by.kabral.eventsnotificator.service

import by.kabral.eventsnotificator.dto.PersonDto
import by.kabral.eventsnotificator.exception.BusinessLogicException
import by.kabral.eventsnotificator.mapper.PeopleMapper
import by.kabral.eventsnotificator.model.Person
import by.kabral.eventsnotificator.repository.PeopleRepository
import by.kabral.eventsnotificator.util.Message.PERSON_NOT_FOUND
import by.kabral.eventsnotificator.util.Message.PERSON_WITH_ID_NOT_FOUND
import by.kabral.eventsnotificator.util.Message.TOO_MANY_PEOPLE
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PeopleService(
  private val peopleRepository: PeopleRepository,
  private val peopleMapper: PeopleMapper
) {

  fun getPeopleDto(): List<PersonDto> {
    return findAll()
      .map { peopleMapper.toDto(it) }
  }

  fun findAll(): List<Person> {
    return peopleRepository
      .findAll()
  }

  fun findById(id: UUID): Person {
    return peopleRepository
      .findById(id)
      .orElseThrow { EntityNotFoundException(String.format(PERSON_WITH_ID_NOT_FOUND, id)) }
  }

  fun getPersonDtoById(id: UUID): PersonDto {
    return peopleMapper.toDto(findById(id))
  }

  fun findPerson(person: PersonDto): Person {
    return findByLastname(person.lastname)
      ?: findByLastnameAndFirstName(person.lastname, person.firstname)
      ?: findByLastNameAndFirstnameAndMiddleName(person.lastname, person.firstname, person.middleName)
      ?: throw BusinessLogicException(PERSON_NOT_FOUND)
  }

  fun findByLastname(lastname: String): Person? {
    val people = peopleRepository.findByLastname(lastname)
    validateListOfPeople(people)
    return people.firstOrNull()
  }

  fun findByLastnameAndFirstName(lastname: String, firstname: String): Person? {
    val people = peopleRepository.findByLastnameAndFirstname(lastname, firstname)
    validateListOfPeople(people)
    return people.firstOrNull()
  }

  fun findByLastNameAndFirstnameAndMiddleName(
    lastname: String, firstname: String, middleName: String
  ): Person? {
    val people = peopleRepository.findByLastnameAndFirstnameAndMiddleName(
      lastname = lastname,
      firstname = firstname,
      middleName = middleName
    )
    validateListOfPeople(people)
    return people.firstOrNull()
  }

  private fun validateListOfPeople(people: List<Person>) {
    if (people.size > COUNT_OF_PERSON_SEARCHING) {
      throw BusinessLogicException(TOO_MANY_PEOPLE)
    }
  }

  private companion object {
    private const val COUNT_OF_PERSON_SEARCHING = 1
  }
}