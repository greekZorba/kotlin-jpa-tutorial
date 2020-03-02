package com.jpa.hellojpa

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Member (
        @Id
        val id: Long = 0,
        val name: String = ""
)