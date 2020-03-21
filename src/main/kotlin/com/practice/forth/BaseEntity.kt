package com.practice.forth

import java.time.LocalDateTime
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class BaseEntity(
  var createdBy: String? = null,
  var createdDate: LocalDateTime? = null,
  var lastModifiedBy: String? = null,
  var modifiedDate: LocalDateTime? = null
)