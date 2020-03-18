package com.practice.third.domain

import javax.persistence.*

@Entity
class MemberProduct(

    @Id
    @GeneratedValue
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    var member: Member,

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    var product: Product
)