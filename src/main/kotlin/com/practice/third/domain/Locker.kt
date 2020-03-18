package com.practice.third.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Locker (
    @Id
    @GeneratedValue
    val id: Long = 0,

    val name: String,

    @OneToOne(mappedBy = "locker")
    val member: Member? = null
)