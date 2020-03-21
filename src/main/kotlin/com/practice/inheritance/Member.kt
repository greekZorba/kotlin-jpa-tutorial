package com.practice.inheritance

import javax.persistence.*

@Entity
data class Member(
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    val id: Long = 0,
    val name: String,
    val city: String

    ) : BaseEntity()