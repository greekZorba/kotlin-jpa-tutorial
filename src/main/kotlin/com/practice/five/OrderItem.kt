package com.practice.five

import com.practice.third.domain.Item
import com.practice.third.domain.Order
import com.practice.third.domain.OrderStatus
import java.time.LocalDateTime
import javax.persistence.*
import javax.persistence.FetchType.LAZY

@Entity
data class OrderItem (
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    val id: Long,

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ORDER_ID")
    val order: Order,

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ITEM_ID")
    val item: Item,

    val orderDate: LocalDateTime,

    @Enumerated(EnumType.STRING)
    val orderStatus: OrderStatus
)