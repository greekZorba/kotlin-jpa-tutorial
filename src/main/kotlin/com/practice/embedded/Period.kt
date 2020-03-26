package com.practice.embedded

import java.time.LocalDateTime
import javax.persistence.Embeddable

@Embeddable
data class Period (
    var startDate: LocalDateTime,
    var endDate: LocalDateTime
) {
    var isWorking = LocalDateTime.now().isBefore(this.startDate)
}