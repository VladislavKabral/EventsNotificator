package by.kabral.eventsnotificator.service.notification

import by.kabral.eventsnotificator.model.Event
import by.kabral.eventsnotificator.model.EventType

interface NotificationBuilder {
  val type: EventType
  fun build(event: Event): String
}