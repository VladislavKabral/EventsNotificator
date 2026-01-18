package by.kabral.eventsnotificator.service

import by.kabral.eventsnotificator.dto.RemovedEntityDto
import by.kabral.eventsnotificator.dto.events.EventDto
import by.kabral.eventsnotificator.dto.events.EventsDto
import by.kabral.eventsnotificator.mapper.EventTypesMapper
import by.kabral.eventsnotificator.mapper.EventsMapper
import by.kabral.eventsnotificator.model.Event
import by.kabral.eventsnotificator.repository.EventsRepository
import by.kabral.eventsnotificator.util.Message.EVENT_NOT_FOUND
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class EventsService(
  private val eventsRepository: EventsRepository,
  private val eventsMapper: EventsMapper,
  private val eventTypeMapper: EventTypesMapper
) : BaseService<Event, EventDto> {

  fun findEvents() : EventsDto {
    return EventsDto(
      findAll().map { eventsMapper.toDto(it) }
    )
  }

  override fun findAll(): List<Event> {
    return eventsRepository.findAll()
  }

  fun findEvent(id : UUID) : EventDto {
    return findById(id).let { eventsMapper.toDto(it) }
  }

  override fun findById(id: UUID): Event {
    return eventsRepository
      .findById(id)
      .orElseThrow { EntityNotFoundException(String.format(EVENT_NOT_FOUND, id)) }
  }

  @Transactional
  override fun save(dto: EventDto): EventDto {
    val event = eventsMapper.toEntity(dto)

    return eventsRepository.save(event).let { eventsMapper.toDto(it) }
  }

  @Transactional
  override fun update(id: UUID, dto: EventDto): EventDto {
    val event = findById(id)

    dto.name?.let { name -> event.name = name }
    dto.description?.let { description -> event.description = description }
    dto.type.let { type -> event.type = eventTypeMapper.toEntity(type) }

    return eventsRepository.save(event).let { eventsMapper.toDto(it) }
  }

  @Transactional
  override fun delete(id: UUID): RemovedEntityDto {
    val event = findById(id)
    eventsRepository.delete(event)

    return RemovedEntityDto(id)
  }
}