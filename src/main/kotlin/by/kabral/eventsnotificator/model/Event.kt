package by.kabral.eventsnotificator.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import java.time.LocalDate
import java.util.UUID

@Entity(name = "events")
data class Event(

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.UUID)
  val id: UUID?,

  @Column(name = "name")
  var name: String,

  @Column(name = "description")
  var description: String?,

  @Column(name = "date")
  var date: LocalDate,

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "type_id")
  var type: EventType,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id")
  val relatedPerson: Person?,

  @ManyToMany(mappedBy = "subscriptions")
  val users: MutableList<User>? = mutableListOf()
)
