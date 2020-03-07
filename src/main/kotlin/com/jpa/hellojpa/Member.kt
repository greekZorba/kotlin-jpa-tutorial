package com.jpa.hellojpa

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class Member(
        @Id
        val id: Long,

        @Column(name="name")
        var username: String,

        var age: Int,

        @Enumerated(EnumType.STRING)
        val roleType: RoleType,

        @Temporal(TemporalType.TIMESTAMP)
        val createDate: Date,

        @Temporal(TemporalType.TIMESTAMP)
        val lastModifiedDate: Date,

        @Lob
        val description: String
)