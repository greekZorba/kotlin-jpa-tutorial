package com.practice.second.domain

import javax.persistence.*

@Entity
data class Member(
        @Id
        @GeneratedValue
        @Column(name = "MEMBER_ID")
        val id: Long = 0,
        val name: String,
        val city: String,

        @ManyToOne
        @JoinColumn(name = "TEAM_ID")
        var team: Team,

        @OneToOne
        @JoinColumn(name = "LOCKER_ID")
        var locker: Locker,

        @ManyToMany
        @JoinTable(name = "MEMBER_PRODUCT")
        val products: List<Product> = ArrayList(),

        val street: String,
        val zipcode: String,

        @OneToMany(mappedBy = "member")
        val orders: List<Order> = ArrayList()
)