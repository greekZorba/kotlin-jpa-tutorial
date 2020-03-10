package jpabook.jpashop.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Member(
        @Id
        @GeneratedValue
        val id: Long,
        val name: String,
        val city: String,
        val street: String,
        val zipcode: String
)