package by.kabral.eventsnotificator.controller

import by.kabral.eventsnotificator.service.EventsService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/events")
class EventsController(
  private val eventsService: EventsService,
) {

}