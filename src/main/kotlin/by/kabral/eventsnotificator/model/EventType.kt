package by.kabral.eventsnotificator.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.UUID

@Entity(name = "events_types")
data class EventType(

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.UUID)
  val id: UUID?,

  @Column(name = "name")
  val name: String,

  @Column(name = "description")
  val description: String?
)
