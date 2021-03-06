package com.practice.third.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "ORDERS")
class Order(
        @Id
        @GeneratedValue
        @Column(name = "ORDER_ID")
        val id: Long,

        @ManyToOne
        @JoinColumn(name = "MEMBER_ID")
        val member: Member,

        @OneToMany(mappedBy = "order")
        val orderItems: List<OrderItem>,

        @OneToOne
        @JoinColumn(name = "DELIVERY_ID")
        val delivery: Delivery,

        val orderDate: LocalDateTime,

        @Enumerated(EnumType.STRING)
        val status: OrderStatus
)