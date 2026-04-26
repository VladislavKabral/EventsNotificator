package by.kabral.eventsnotificator.service.notification

import by.kabral.eventsnotificator.extensions.fullName
import by.kabral.eventsnotificator.model.Event
import by.kabral.eventsnotificator.model.EventType
import by.kabral.eventsnotificator.util.Template.BIRTHDAY
import by.kabral.eventsnotificator.util.Wish
import org.springframework.stereotype.Component

@Component
class BirthdayNotificationBuilder : NotificationBuilder {

  override val type = EventType.BIRTHDAY

  override fun build(event: Event): String {
    return BIRTHDAY
      .replace("\$date", event.date.toString())
      .replace("\$fullName", event.relatedPerson?.fullName() ?: "")
      .replace("\$wish", Wish.getRandomWish())
  }
}