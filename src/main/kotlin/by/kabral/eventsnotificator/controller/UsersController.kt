package by.kabral.eventsnotificator.controller

import by.kabral.eventsnotificator.dto.RemovedEntityDto
import by.kabral.eventsnotificator.dto.users.UserDto
import by.kabral.eventsnotificator.dto.users.UsersDto
import by.kabral.eventsnotificator.service.UsersService
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
@RequestMapping("/users")
class UsersController(
  private val usersService: UsersService,
) {

  @GetMapping
  fun getUsers(): ResponseEntity<UsersDto> {
    return ResponseEntity.ok(usersService.findUsers())
  }

  @GetMapping("/{id}")
  fun getUser(@PathVariable id: UUID): ResponseEntity<UserDto> {
    return ResponseEntity.ok(usersService.findUser(id))
  }

  @PostMapping
  fun saveUser(@RequestBody user: UserDto): ResponseEntity<UserDto> {
    return ResponseEntity(usersService.save(user), HttpStatus.CREATED)
  }

  @PutMapping("/{id}")
  fun updateUser(@PathVariable id: UUID, @RequestBody user: UserDto): ResponseEntity<UserDto> {
    return ResponseEntity.ok(usersService.update(id, user))
  }

  @DeleteMapping("/{id}")
  fun deleteUser(@PathVariable id: UUID): ResponseEntity<RemovedEntityDto> {
    return ResponseEntity.ok(usersService.delete(id))
  }
}