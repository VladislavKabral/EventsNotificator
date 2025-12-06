package by.kabral.eventsnotificator.repository

import by.kabral.eventsnotificator.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UsersRepository : JpaRepository<User, UUID> {
}