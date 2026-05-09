package by.kabral.eventsnotificator.service.notification

import by.kabral.eventsnotificator.model.Event
import by.kabral.eventsnotificator.model.EventType
import by.kabral.eventsnotificator.util.Constant.DATE_FORMAT
import by.kabral.eventsnotificator.util.Template.WEDDING_ANNIVERSARY
import org.springframework.stereotype.Component
import java.time.format.DateTimeFormatter

@Component
class WeddingAnniversaryNotificationBuilder : NotificationBuilder {

  override val type = EventType.WEDDING_ANNIVERSARY
  private val formatter = DateTimeFormatter.ofPattern(DATE_FORMAT)

  override fun build(event: Event): String {
    return WEDDING_ANNIVERSARY
      .replace("\$date", event.date.format(formatter))
      .replace("\$description", event.description ?: "")
  }
}