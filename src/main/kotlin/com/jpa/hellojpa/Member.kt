package com.jpa.hellojpa

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 1
)
data class Member(
        @Id
        @GeneratedValue(strategy = GenerationType.TABLE, generator = "MEMBER_SEQ_GENERATOR")
        val id: Long = 0,

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
) {

}