package by.kabral.eventsnotificator.service

import by.kabral.eventsnotificator.dto.RemovedEntityDto
import by.kabral.eventsnotificator.dto.events.EventDto
import by.kabral.eventsnotificator.dto.events.EventsDto
import by.kabral.eventsnotificator.dto.users.UserDto
import by.kabral.eventsnotificator.mapper.EventsMapper
import by.kabral.eventsnotificator.model.Event
import by.kabral.eventsnotificator.repository.EventsRepository
import by.kabral.eventsnotificator.service.notification.CompositeNotificationBuilder
import by.kabral.eventsnotificator.util.Constant.MAIL_SUBJECT
import by.kabral.eventsnotificator.util.Message.EVENT_NOT_FOUND
import by.kabral.eventsnotificator.util.Message.NAME_IS_EMPTY_FOR_NEW_EVENT
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class EventsService(
  private val eventsRepository: EventsRepository,
  private val eventsMapper: EventsMapper,
  private val notificationBuilder: CompositeNotificationBuilder,
  private val usersService: UsersService,
  private val mailSender: JavaMailSender,
  @param:Value("\${spring.mail.username}") private val mailUsername: String
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

  @Scheduled(cron = "\${notifications.cron}")
  fun sendNotifications() {
    val currentDate = LocalDate.now()

    val events = eventsRepository.findByDate(currentDate)

    for (event in events) {
      val notificationBody = notificationBuilder.build(event)
      val message = mailSender.createMimeMessage()
      val helper = MimeMessageHelper(message, "UTF-8")

      helper.setSubject(MAIL_SUBJECT)
      helper.setFrom(mailUsername)
      helper.setText(notificationBody, true)

      val emails = event.subscribers
        .map { it.email }
        .toTypedArray()

      if (emails.isNotEmpty()) {
        helper.setTo(emails)
        mailSender.send(message)
      }
    }
  }

  @Transactional
  fun assignEventToSubscriber(eventId: UUID, userId: UUID): UserDto {
    val event = findById(eventId)
    val subscriber = usersService.findById(userId)
    event.subscribers.add(subscriber)
    subscriber.subscriptions.add(event)

    return usersService.save(subscriber)
  }

  @Transactional
  override fun save(dto: EventDto): EventDto {
    requireNotNull(dto.name) { NAME_IS_EMPTY_FOR_NEW_EVENT }
    val event = eventsMapper.toEntity(dto)

    return eventsRepository.save(event).let { eventsMapper.toDto(it) }
  }

  @Transactional
  override fun update(id: UUID, dto: EventDto): EventDto {
    val event = findById(id)

    dto.name?.let { name -> event.name = name }
    dto.description?.let { description -> event.description = description }
    dto.date?.let { date -> event.date = date }

    return eventsRepository.save(event).let { eventsMapper.toDto(it) }
  }

  @Transactional
  override fun delete(id: UUID): RemovedEntityDto {
    val event = findById(id)
    eventsRepository.delete(event)

    return RemovedEntityDto(id)
  }
}