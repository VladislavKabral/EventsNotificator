package by.kabral.eventsnotificator.service

import by.kabral.eventsnotificator.dto.RemovedEntityDto
import java.util.UUID

interface BaseService<T, K> {
  fun findAll(): List<T>
  fun findById(id: UUID): T
  fun save(dto: K): K
  fun update(id: UUID, dto: K): K
  fun delete(id: UUID): RemovedEntityDto
}