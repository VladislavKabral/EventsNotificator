package by.kabral.eventsnotificator.service

import by.kabral.eventsnotificator.dto.RemovedEntityDto
import by.kabral.eventsnotificator.dto.users.UserDto
import by.kabral.eventsnotificator.dto.users.UsersDto
import by.kabral.eventsnotificator.mapper.UsersMapper
import by.kabral.eventsnotificator.model.User
import by.kabral.eventsnotificator.repository.UsersRepository
import by.kabral.eventsnotificator.util.Message.USER_NOT_FOUND
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UsersService(
  private val usersRepository: UsersRepository,
  private val usersMapper: UsersMapper
) : BaseService<User, UserDto> {

  fun findUsers(): UsersDto {
    return UsersDto(
      findAll()
      .map { usersMapper.toDto(it) }
    )
  }

  override fun findAll(): List<User> {
    return usersRepository.findAll()
  }

  fun findUser(id: UUID): UserDto {
    return findById(id).let { usersMapper.toDto(it) }
  }

  override fun findById(id: UUID): User {
    return usersRepository
      .findById(id)
      .orElseThrow { EntityNotFoundException(USER_NOT_FOUND) }
  }

  @Transactional
  override fun save(dto: UserDto): UserDto {
    val user = usersMapper.toEntity(dto)

    return usersRepository.save(user).let{ usersMapper.toDto(it) }
  }

  fun save(user: User): UserDto {
    return usersRepository.save(user).let{ usersMapper.toDto(it) }
  }

  @Transactional
  override fun update(id: UUID, dto: UserDto): UserDto {
    val user = findById(id)

    dto.lastname?.let { lastname -> user.lastname = lastname }
    dto.firstname?.let { firstname -> user.firstname = firstname }
    dto.email?.let { email -> user.email = email }
    dto.dateOfBirth?.let { dateOfBirth -> user.dateOfBirth = dateOfBirth }

    return usersRepository.save(user).let{ usersMapper.toDto(it) }
  }

  @Transactional
  override fun delete(id: UUID): RemovedEntityDto {
    val user = findById(id)
    usersRepository.delete(user)

    return RemovedEntityDto(id)
  }
}