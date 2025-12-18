package by.kabral.eventsnotificator.mapper

import by.kabral.eventsnotificator.dto.users.UserDto
import by.kabral.eventsnotificator.model.User
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface UsersMapper {
  fun toDto(entity: User): UserDto
  fun toEntity(dto: UserDto): User
}