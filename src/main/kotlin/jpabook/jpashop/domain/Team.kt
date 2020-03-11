package jpabook.jpashop.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Team (
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    val id: Long = 0
)