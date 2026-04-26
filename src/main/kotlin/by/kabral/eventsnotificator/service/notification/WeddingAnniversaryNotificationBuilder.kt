package by.kabral.eventsnotificator.service.notification

import by.kabral.eventsnotificator.model.Event
import by.kabral.eventsnotificator.model.EventType
import by.kabral.eventsnotificator.util.Template.WEDDING_ANNIVERSARY
import org.springframework.stereotype.Component

@Component
class WeddingAnniversaryNotificationBuilder : NotificationBuilder {
  override val type = EventType.WEDDING_ANNIVERSARY

  override fun build(event: Event): String {
    return WEDDING_ANNIVERSARY
      .replace("\$date", event.date.toString())
      .replace("\$description", event.description ?: "")
  }
}