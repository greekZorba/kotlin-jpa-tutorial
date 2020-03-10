package jpabook.jpashop.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class OrderItem (
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    val id: Long,

    @Column(name = "ORDER_ID")
    val orderId: Long,

    @Column(name = "ITEM_ID")
    val itemId: Long,

    val orderDate: LocalDateTime,

    @Enumerated(EnumType.STRING)
    val orderStatus: OrderStatus
)