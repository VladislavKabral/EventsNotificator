package by.kabral.eventsnotificator.service.notification

import by.kabral.eventsnotificator.model.Event
import by.kabral.eventsnotificator.model.EventType
import by.kabral.eventsnotificator.util.Template.UNIVERSAL
import org.springframework.stereotype.Component

@Component
class DefaultNotificationBuilder : NotificationBuilder {

  override val type = EventType.UNIVERSAL

  override fun build(event: Event): String {
    return UNIVERSAL
      .replace("\$date", event.date.toString())
      .replace("\$name", event.name)
      .replace("\$description", event.description ?: "")
  }
}