package com.jpa.hellojpa

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
data class Member(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
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