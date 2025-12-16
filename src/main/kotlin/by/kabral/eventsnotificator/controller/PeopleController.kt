package by.kabral.eventsnotificator.controller

import by.kabral.eventsnotificator.dto.PeopleDto
import by.kabral.eventsnotificator.dto.PersonDto
import by.kabral.eventsnotificator.dto.RemovedEntityDto
import by.kabral.eventsnotificator.service.PeopleService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/people")
class PeopleController(
  private val peopleService: PeopleService
) {

  @GetMapping
  fun getPeople() : ResponseEntity<PeopleDto> {
    return ResponseEntity.ok(peopleService.getPeopleDto())
  }

  @GetMapping("/{id}")
  fun getPerson(@PathVariable id: UUID) : ResponseEntity<PersonDto> {
    return ResponseEntity.ok(peopleService.getPersonDtoById(id))
  }

  @PostMapping
  fun savePerson(@RequestBody person: PersonDto) : ResponseEntity<PersonDto> {
    return ResponseEntity(peopleService.save(person), HttpStatus.CREATED)
  }

  @PutMapping("/{id}")
  fun updatePerson(@PathVariable id: UUID, @RequestBody person: PersonDto) : ResponseEntity<PersonDto> {
    return ResponseEntity.ok(peopleService.update(id, person))
  }

  @DeleteMapping("/{id}")
  fun deletePerson(@PathVariable id: UUID) : ResponseEntity<RemovedEntityDto> {
    return ResponseEntity.ok(peopleService.delete(id))
  }
}