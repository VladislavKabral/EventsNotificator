package by.kabral.eventsnotificator.service.notification

import by.kabral.eventsnotificator.extensions.fullName
import by.kabral.eventsnotificator.model.Event
import by.kabral.eventsnotificator.model.EventType
import by.kabral.eventsnotificator.util.Constant.DATE_FORMAT
import by.kabral.eventsnotificator.util.Template.BIRTHDAY
import by.kabral.eventsnotificator.util.Wish
import org.springframework.stereotype.Component
import java.time.format.DateTimeFormatter

@Component
class BirthdayNotificationBuilder : NotificationBuilder {

  override val type = EventType.BIRTHDAY
  private val formatter = DateTimeFormatter.ofPattern(DATE_FORMAT)

  override fun build(event: Event): String {
    return BIRTHDAY
      .replace("\$date", event.date.format(formatter))
      .replace("\$fullName", event.relatedPerson?.fullName() ?: "")
      .replace("\$wish", Wish.getRandomWish())
  }
}