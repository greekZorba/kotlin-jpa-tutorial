package com.practice.jpql

import javax.persistence.*

@Entity
data class Member(
    @Id
    @GeneratedValue
    val id: Long = 0,
    val name: String
)