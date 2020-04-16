package com.practice.namedQuery

import javax.persistence.*

@Entity
class Team (
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    val id: Long = 0,

    @Column(name = "NAME")
    var name: String = "",

    @OneToMany(mappedBy = "team")
    var members: MutableList<Member> = ArrayList()
) {
    fun addMember(member: Member) {
        member.team = this
        members.add(member)
    }
}