package by.kabral.eventsnotificator.controller

import by.kabral.eventsnotificator.dto.RemovedEntityDto
import by.kabral.eventsnotificator.dto.events.EventDto
import by.kabral.eventsnotificator.dto.events.EventsDto
import by.kabral.eventsnotificator.dto.users.UserDto
import by.kabral.eventsnotificator.service.EventsService
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
import java.util.UUID

@RestController
@RequestMapping("/events")
class EventsController(
  private val eventsService: EventsService,
) {

  @GetMapping
  fun getEvents() : ResponseEntity<EventsDto> {
    return ResponseEntity.ok(eventsService.findEvents())
  }

  @GetMapping("/{id}")
  fun getEvent(@PathVariable id: UUID) : ResponseEntity<EventDto> {
    return ResponseEntity.ok(eventsService.findEvent(id))
  }

  @PostMapping
  fun saveEvent(@RequestBody eventDto: EventDto) : ResponseEntity<EventDto> {
    return ResponseEntity(eventsService.save(eventDto), HttpStatus.CREATED)
  }

  @PutMapping("/{eventId}/assign/{userId}")
  fun assignEvent(@PathVariable eventId: UUID, @PathVariable userId: UUID) : ResponseEntity<UserDto> {
    return ResponseEntity(eventsService.assignEventToSubscriber(eventId, userId), HttpStatus.OK)
  }

  @PutMapping("/{id}")
  fun updateEvent(@PathVariable id: UUID, @RequestBody eventDto: EventDto) : ResponseEntity<EventDto> {
    return ResponseEntity.ok(eventsService.update(id, eventDto))
  }

  @DeleteMapping("/{id}")
  fun deleteEvent(@PathVariable id: UUID) : ResponseEntity<RemovedEntityDto> {
    return ResponseEntity.ok(eventsService.delete(id))
  }
}