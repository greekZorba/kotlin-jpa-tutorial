package com.practice.third.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Delivery(

    @Id
    @GeneratedValue
    val id: Long = 0,

    val city: String,
    val street: String,
    val zipCode: String,
    val status: DeliveryStatus,

    @OneToOne(mappedBy = "delivery")
    val order: Order
)