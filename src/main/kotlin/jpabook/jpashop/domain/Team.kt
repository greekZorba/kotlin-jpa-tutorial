package jpabook.jpashop.domain

import javax.persistence.*

@Entity
data class Team (
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    val id: Long = 0,

    @OneToMany(mappedBy = "team")
    val members: List<Member> = ArrayList()
)