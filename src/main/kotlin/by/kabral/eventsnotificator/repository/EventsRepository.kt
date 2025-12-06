package by.kabral.eventsnotificator.repository

import by.kabral.eventsnotificator.model.Event
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface EventsRepository : JpaRepository<Event, UUID> {
}