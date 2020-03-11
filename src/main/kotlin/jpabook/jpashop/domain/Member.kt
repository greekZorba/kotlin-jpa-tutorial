package jpabook.jpashop.domain

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
        val team: Team,

        val street: String,
        val zipcode: String
)