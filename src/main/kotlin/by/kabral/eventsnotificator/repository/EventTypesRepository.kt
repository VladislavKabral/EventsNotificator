package by.kabral.eventsnotificator.repository

import by.kabral.eventsnotificator.model.EventType
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface EventTypesRepository : JpaRepository<EventType, UUID> {
}