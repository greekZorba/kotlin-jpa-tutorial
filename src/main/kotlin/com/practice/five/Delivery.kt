package com.practice.five

import javax.persistence.*
import javax.persistence.FetchType.*

@Entity
class Delivery(

    @Id
    @GeneratedValue
    val id: Long = 0,

    val city: String,
    val street: String,
    val zipCode: String,

    @OneToOne(mappedBy = "delivery", fetch = LAZY, cascade = [CascadeType.ALL])
    val order: Order
)