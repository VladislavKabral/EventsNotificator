package by.kabral.eventsnotificator.repository

import by.kabral.eventsnotificator.model.Event
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDate
import java.util.UUID

interface EventsRepository : JpaRepository<Event, UUID> {
  @Query(
    """
    SELECT DISTINCT e FROM events e
    LEFT JOIN FETCH e.subscribers
    LEFT JOIN FETCH e.relatedPerson
    WHERE e.date = :date
    """
  )
  fun findByDate(@Param("date") date: LocalDate): List<Event>
}