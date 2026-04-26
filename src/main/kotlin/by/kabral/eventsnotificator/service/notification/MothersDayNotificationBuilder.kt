package by.kabral.eventsnotificator.service.notification

import by.kabral.eventsnotificator.model.Event
import by.kabral.eventsnotificator.model.EventType
import by.kabral.eventsnotificator.util.Template.MOTHERS_DAY
import org.springframework.stereotype.Component

@Component
class MothersDayNotificationBuilder : NotificationBuilder {
  override val type = EventType.MOTHERS_DAY


  override fun build(event: Event): String {
    return MOTHERS_DAY
  }
}