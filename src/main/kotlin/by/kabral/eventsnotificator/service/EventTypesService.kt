package by.kabral.eventsnotificator.service

import by.kabral.eventsnotificator.dto.EventTypeDto
import by.kabral.eventsnotificator.mapper.EventTypesMapper
import by.kabral.eventsnotificator.model.EventType
import by.kabral.eventsnotificator.repository.EventTypesRepository
import by.kabral.eventsnotificator.util.Message.EVENT_TYPE_NOT_FOUND
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class EventTypesService(
  private val eventTypesRepository: EventTypesRepository,
  private val eventTypesMapper: EventTypesMapper
) {

  fun getEventTypesDto(): List<EventTypeDto> {
    return findAll()
      .map { eventTypesMapper.toDto(it) }
  }

  fun findAll(): List<EventType> {
    return eventTypesRepository.findAll()
  }

  fun getEventTypeDto(id: UUID): EventTypeDto {
    return eventTypesMapper.toDto(findById(id))
  }

  fun findById(id: UUID): EventType {
    return eventTypesRepository
      .findById(id)
      .orElseThrow { EntityNotFoundException(String.format(EVENT_TYPE_NOT_FOUND, id)) }
  }
}