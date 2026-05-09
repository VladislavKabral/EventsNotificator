package by.kabral.eventsnotificator.service.notification

import by.kabral.eventsnotificator.model.Event
import by.kabral.eventsnotificator.model.EventType
import by.kabral.eventsnotificator.util.Constant.DATE_FORMAT
import by.kabral.eventsnotificator.util.Template.UNIVERSAL
import org.springframework.stereotype.Component
import java.time.format.DateTimeFormatter

@Component
class DefaultNotificationBuilder : NotificationBuilder {

  override val type = EventType.UNIVERSAL
  private val formatter = DateTimeFormatter.ofPattern(DATE_FORMAT)

  override fun build(event: Event): String {
    return UNIVERSAL
      .replace("\$date", event.date.format(formatter))
      .replace("\$name", event.name)
      .replace("\$description", event.description ?: "")
  }
}