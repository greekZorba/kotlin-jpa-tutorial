package jpabook.jpashop.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "ORDERS")
class Order(
        @Id
        @GeneratedValue
        @Column(name = "ORDER_ID")
        val id: Long,

        @Column(name = "MEMBER_ID")
        val memberId: Long,

        val orderDate: LocalDateTime,

        @Enumerated(EnumType.STRING)
        val status: OrderStatus
)