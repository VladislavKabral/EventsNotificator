package by.kabral.eventsnotificator.service

import by.kabral.eventsnotificator.dto.people.PeopleDto
import by.kabral.eventsnotificator.dto.people.PersonDto
import by.kabral.eventsnotificator.dto.RemovedEntityDto
import by.kabral.eventsnotificator.exception.BusinessLogicException
import by.kabral.eventsnotificator.exception.EntityNotSavedException
import by.kabral.eventsnotificator.mapper.PeopleMapper
import by.kabral.eventsnotificator.model.Person
import by.kabral.eventsnotificator.repository.PeopleRepository
import by.kabral.eventsnotificator.util.Message.PERSON_NOT_FOUND
import by.kabral.eventsnotificator.util.Message.PERSON_NOT_SAVED
import by.kabral.eventsnotificator.util.Message.PERSON_WITH_ID_NOT_FOUND
import by.kabral.eventsnotificator.util.Message.TOO_MANY_PEOPLE
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PeopleService(
  private val peopleRepository: PeopleRepository,
  private val peopleMapper: PeopleMapper
) : BaseService<Person, PersonDto> {

  fun findPeople(): PeopleDto {
    return PeopleDto(
      findAll()
      .map { peopleMapper.toDto(it) }
    )
  }

  override fun findAll(): List<Person> {
    return peopleRepository
      .findAll()
  }

  override fun findById(id: UUID): Person {
    return peopleRepository
      .findById(id)
      .orElseThrow { EntityNotFoundException(String.format(PERSON_WITH_ID_NOT_FOUND, id)) }
  }

  fun findPerson(id: UUID): PersonDto {
    return peopleMapper.toDto(findById(id))
  }

  fun findPerson(person: PersonDto): Person {
    return findByLastname(person)
      ?: findByLastnameAndFirstName(person)
      ?: findByLastNameAndFirstnameAndMiddleName(person)
      ?: throw BusinessLogicException(TOO_MANY_PEOPLE)
  }

  fun findByLastname(dto: PersonDto): Person? {
    val people = dto.lastname
      ?.let { lastname -> peopleRepository.findByLastname(lastname) }
      ?: return null

    return validateListOfPeople(people)
  }

  fun findByLastnameAndFirstName(dto: PersonDto): Person? {
    val people = dto.lastname?.let { lastname ->
      dto.firstname?.let { firstname ->
        peopleRepository.findByLastnameAndFirstname(lastname, firstname)
      } ?: return null
    } ?: return null

    return validateListOfPeople(people)
  }

  fun findByLastNameAndFirstnameAndMiddleName(dto: PersonDto): Person? {
    val people = dto.lastname?.let { lastname ->
      dto.firstname?.let { firstname ->
        dto.middleName?.let { middleName ->
          peopleRepository.findByLastnameAndFirstnameAndMiddleName(
            lastname = lastname,
            firstname = firstname,
            middleName = middleName
          )
        } ?: return null
      } ?: return null
    } ?: return null

    return validateListOfPeople(people)
  }

  @Transactional
  override fun save(dto: PersonDto): PersonDto {
    val person = peopleMapper.toEntity(dto)

    val newPerson = peopleRepository.save(person)

    return newPerson.id?.let { peopleMapper.toDto(findById(it)) }
      ?: throw EntityNotSavedException(PERSON_NOT_SAVED)
  }

  @Transactional
  override fun update(id: UUID, dto: PersonDto): PersonDto {
    val person = findById(id)

    dto.lastname?.let { lastname -> person.lastname = lastname }
    dto.firstname?.let { firstname -> person.firstname = firstname }
    dto.middleName?.let { middleName -> person.middleName = middleName }

    return peopleMapper.toDto(
      peopleRepository.save(person)
    )
  }

  @Transactional
  override fun delete(id: UUID) : RemovedEntityDto {
    val person = findById(id)
    peopleRepository.delete(person)

    return RemovedEntityDto(id)
  }

  private fun validateListOfPeople(people: List<Person>) : Person? {
    if (people.isEmpty()) {
      throw EntityNotFoundException(PERSON_NOT_FOUND)
    }

    if (people.size > COUNT_OF_PERSON_SEARCHING) {
      return null
    }

    return people.first()
  }

  private companion object {
    private const val COUNT_OF_PERSON_SEARCHING = 1
  }
}