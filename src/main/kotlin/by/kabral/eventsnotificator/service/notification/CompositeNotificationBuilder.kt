package by.kabral.eventsnotificator.service.notification

import by.kabral.eventsnotificator.model.Event
import by.kabral.eventsnotificator.model.EventType
import org.springframework.stereotype.Component

@Component
class CompositeNotificationBuilder(builders: List<NotificationBuilder>) {

  private val buildersMap = builders.associateBy{ it.type }

  fun build(event: Event): String {
    return buildersMap[event.type]?.build(event)
      ?: buildersMap.getValue(EventType.UNIVERSAL).build(event)
  }
}