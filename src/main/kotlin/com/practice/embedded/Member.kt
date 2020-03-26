package com.practice.embedded

import javax.persistence.*

@Entity
data class Member(
        @Id
        @GeneratedValue
        @Column(name = "MEMBER_ID")
        val id: Long = 0,
        val name: String,

        // 기간 Period
        @Embedded
        val workPeriod: Period,

        // 주소 Address
        @Embedded
        val homeAddress: Address
)