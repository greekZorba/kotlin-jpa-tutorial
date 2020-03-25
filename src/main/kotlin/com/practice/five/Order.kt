package com.practice.five

import java.time.LocalDateTime
import javax.persistence.*
import javax.persistence.CascadeType.*
import javax.persistence.FetchType.*

@Entity
@Table(name = "ORDERS")
class Order(
        @Id
        @GeneratedValue
        @Column(name = "ORDER_ID")
        val id: Long,

        @OneToMany(mappedBy = "order", cascade = [ALL])
        val orderItems: List<OrderItem>,

        @OneToOne(fetch = LAZY, cascade = [ALL])
        @JoinColumn(name = "DELIVERY_ID")
        val delivery: Delivery,

        val orderDate: LocalDateTime,
)