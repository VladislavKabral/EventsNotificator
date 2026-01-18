package by.kabral.eventsnotificator.service

import by.kabral.eventsnotificator.dto.RemovedEntityDto
import by.kabral.eventsnotificator.dto.events.EventTypeDto
import by.kabral.eventsnotificator.dto.events.EventTypesDto
import by.kabral.eventsnotificator.mapper.EventTypesMapper
import by.kabral.eventsnotificator.model.EventType
import by.kabral.eventsnotificator.repository.EventTypesRepository
import by.kabral.eventsnotificator.util.Message.EVENT_TYPE_NOT_FOUND
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class EventTypesService(
  private val eventTypesRepository: EventTypesRepository,
  private val eventTypesMapper: EventTypesMapper
) : BaseService<EventType, EventTypeDto> {

  fun findEventTypes(): EventTypesDto {
    return EventTypesDto(
      findAll().map { eventTypesMapper.toDto(it) }
    )
  }

  override fun findAll(): List<EventType> {
    return eventTypesRepository.findAll()
  }

  fun findEventType(id: UUID): EventTypeDto {
    return eventTypesMapper.toDto(findById(id))
  }

  override fun findById(id: UUID): EventType {
    return eventTypesRepository
      .findById(id)
      .orElseThrow { EntityNotFoundException(String.format(EVENT_TYPE_NOT_FOUND, id)) }
  }

  @Transactional
  override fun save(dto: EventTypeDto): EventTypeDto {
    val eventType = eventTypesMapper.toEntity(dto)

    return eventTypesRepository.save(eventType).let { eventTypesMapper.toDto(it) }
  }

  @Transactional
  override fun update(id: UUID, dto: EventTypeDto): EventTypeDto {
    val eventType = findById(id)

    dto.name?.let { name -> eventType.name = name }
    dto.description?.let { description -> eventType.description = description }

    return eventTypesRepository.save(eventType).let { eventTypesMapper.toDto(it) }
  }

  @Transactional
  override fun delete(id: UUID): RemovedEntityDto {
    val evetyType = findById(id)
    eventTypesRepository.delete(evetyType)

    return RemovedEntityDto(id)
  }
}