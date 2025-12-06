package by.kabral.eventsnotificator.service

import by.kabral.eventsnotificator.dto.UserDto
import by.kabral.eventsnotificator.mapper.UsersMapper
import by.kabral.eventsnotificator.repository.UsersRepository
import org.springframework.stereotype.Service

@Service
class UsersService(
  private val usersRepository: UsersRepository,
  private val usersMapper: UsersMapper
) {

  fun findAll(): List<UserDto> {
    return usersRepository
      .findAll()
      .map { usersMapper.toDto(it) }
  }
}