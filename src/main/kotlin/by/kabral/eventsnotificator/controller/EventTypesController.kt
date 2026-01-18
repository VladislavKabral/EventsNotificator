package by.kabral.eventsnotificator.controller

import by.kabral.eventsnotificator.dto.RemovedEntityDto
import by.kabral.eventsnotificator.dto.events.EventTypeDto
import by.kabral.eventsnotificator.dto.events.EventTypesDto
import by.kabral.eventsnotificator.service.EventTypesService
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
@RequestMapping("/eventTypes")
class EventTypesController(
  private val eventTypesService: EventTypesService
) {

  @GetMapping
  fun getEventTypes() : ResponseEntity<EventTypesDto> {
    return ResponseEntity.ok(eventTypesService.findEventTypes())
  }

  @GetMapping("/{id}")
  fun getEventType(@PathVariable id: UUID) : ResponseEntity<EventTypeDto> {
    return ResponseEntity.ok(eventTypesService.findEventType(id))
  }

  @PostMapping
  fun saveEventType(@RequestBody eventTypeDto: EventTypeDto) : ResponseEntity<EventTypeDto> {
    return ResponseEntity(eventTypesService.save(eventTypeDto), HttpStatus.CREATED)
  }

  @PutMapping("/{id}")
  fun updateEventType(@PathVariable id: UUID, @RequestBody eventTypeDto: EventTypeDto) : ResponseEntity<EventTypeDto> {
    return ResponseEntity.ok(eventTypesService.update(id, eventTypeDto))
  }

  @DeleteMapping("/{id}")
  fun deleteEventType(@PathVariable id: UUID) : ResponseEntity<RemovedEntityDto> {
    return ResponseEntity.ok(eventTypesService.delete(id))
  }
}