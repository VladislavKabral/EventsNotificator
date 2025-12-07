package by.kabral.eventsnotificator.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.UUID

@Entity(name = "people")
data class Person(

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.UUID)
  val id: UUID?,

  @Column(name = "lastname")
  val lastname: String,

  @Column(name = "firstname")
  val firstname: String,

  @Column(name = "middle_name")
  val middleName: String
)