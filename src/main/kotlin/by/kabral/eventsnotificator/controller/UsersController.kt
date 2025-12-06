package by.kabral.eventsnotificator.controller

import by.kabral.eventsnotificator.dto.UserDto
import by.kabral.eventsnotificator.service.UsersService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UsersController(
  private val usersService: UsersService,
) {

  @GetMapping
  fun getUsers(): List<UserDto> = usersService.findAll()
}