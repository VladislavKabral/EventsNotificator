package by.kabral.eventsnotificator.service

import by.kabral.eventsnotificator.dto.RemovedEntityDto
import by.kabral.eventsnotificator.dto.events.EventDto
import by.kabral.eventsnotificator.dto.events.EventsDto
import by.kabral.eventsnotificator.mapper.EventsMapper
import by.kabral.eventsnotificator.model.Event
import by.kabral.eventsnotificator.repository.EventTypesRepository
import by.kabral.eventsnotificator.repository.EventsRepository
import by.kabral.eventsnotificator.util.Message.EVENT_NOT_FOUND
import by.kabral.eventsnotificator.util.Message.EVENT_TYPE_ID_IS_EMPTY_FOR_NEW_EVENT
import by.kabral.eventsnotificator.util.Message.NAME_IS_EMPTY_FOR_NEW_EVENT
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class EventsService(
  private val eventsRepository: EventsRepository,
  private val eventTypesRepository: EventTypesRepository,
  private val eventsMapper: EventsMapper,
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
    val typeId = requireNotNull(dto.type.id) { EVENT_TYPE_ID_IS_EMPTY_FOR_NEW_EVENT }
    val type = eventTypesRepository.getReferenceById(typeId)

    requireNotNull(dto.name) { NAME_IS_EMPTY_FOR_NEW_EVENT }
    val event = eventsMapper.toEntity(dto).copy(type = type)

    return eventsRepository.save(event).let { eventsMapper.toDto(it) }
  }

  @Transactional
  override fun update(id: UUID, dto: EventDto): EventDto {
    val event = findById(id)

    dto.name?.let { name -> event.name = name }
    dto.description?.let { description -> event.description = description }
    dto.date?.let { date -> event.date = date }
    dto.type.id?.let { typeId -> event.type = eventTypesRepository.getReferenceById(typeId) }

    return eventsRepository.save(event).let { eventsMapper.toDto(it) }
  }

  @Transactional
  override fun delete(id: UUID): RemovedEntityDto {
    val event = findById(id)
    eventsRepository.delete(event)

    return RemovedEntityDto(id)
  }
}