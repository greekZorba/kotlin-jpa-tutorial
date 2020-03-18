package com.practice.third.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Product (
    @Id
    @GeneratedValue
    val id: Long = 0
)