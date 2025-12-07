package by.kabral.eventsnotificator.controller

import by.kabral.eventsnotificator.service.EventTypesService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/eventTypes")
class EventTypesController(
  private val eventTypesService: EventTypesService
) {
}