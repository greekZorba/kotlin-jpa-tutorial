package com.practice.jpql

import javax.persistence.*

@Entity
data class Team (
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    val id: Long = 0,

    @Column(name = "NAME")
    var name: String = ""
)