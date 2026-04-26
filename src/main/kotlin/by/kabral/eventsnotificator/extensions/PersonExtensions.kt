package by.kabral.eventsnotificator.extensions

import by.kabral.eventsnotificator.model.Person

fun Person.fullName(): String {
  return listOf(lastname, firstname, middleName)
    .filter { !it.isNullOrBlank() }
    .joinToString(" ")
}