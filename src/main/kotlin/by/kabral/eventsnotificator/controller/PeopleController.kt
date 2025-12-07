package by.kabral.eventsnotificator.controller

import by.kabral.eventsnotificator.service.PeopleService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/people")
class PeopleController(
  private val peopleService: PeopleService
) {
}