package by.kabral.eventsnotificator.repository

import by.kabral.eventsnotificator.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PeopleRepository : JpaRepository<Person, UUID> {
  fun findByLastname(lastName: String): List<Person>
  fun findByLastnameAndFirstname(lastName: String, firstname: String): List<Person>
  fun findByLastnameAndFirstnameAndMiddleName(lastname: String, firstname: String, middleName: String): List<Person>
}