package by.kabral.eventsnotificator.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import java.time.LocalDate
import java.util.*

@Entity(name = "users")
data class User(

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.UUID)
  val id: UUID?,

  @Column(name = "lastname")
  val lastname: String,

  @Column(name = "firstname")
  val firstname: String,

  @Column(name = "email")
  val email: String,

  @Column(name = "password")
  val password: String,

  @Column(name = "date_of_birthday")
  val dateOfBirth: LocalDate,

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "subscriptions",
    joinColumns = [JoinColumn(name = "user_id")],
    inverseJoinColumns = [JoinColumn(name = "event_id")]
  )
  val subscriptions: MutableList<Event> = mutableListOf(),
)
