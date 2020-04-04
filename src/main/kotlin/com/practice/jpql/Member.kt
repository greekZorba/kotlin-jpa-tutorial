package com.practice.jpql

import javax.persistence.*

@Entity
data class Member(
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    val id: Long = 0,
    val name: String,

    // 주소 Address
    @Embedded
    val homeAddress: Address,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    val team: Team
)