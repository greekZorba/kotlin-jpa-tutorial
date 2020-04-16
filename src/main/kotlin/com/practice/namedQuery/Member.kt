package com.practice.namedQuery

import javax.persistence.*

@Entity
@NamedQuery(
    name = "Member.findByName",
    query = "select m from Member m where m.name = :name"
)
class Member(
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    val id: Long = 0,
    val name: String,
    val age: Int,

    // 주소 Address
    @Embedded
    val homeAddress: Address,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    var team: Team
)