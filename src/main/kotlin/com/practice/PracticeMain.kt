package com.practice

import com.practice.paging.Address
import com.practice.paging.Member
import com.practice.paging.Team
import javax.persistence.Persistence

class PracticeMain

fun main() {
    val entityManagerFactory = Persistence.createEntityManagerFactory("practice")
    val entityManager = entityManagerFactory.createEntityManager()

    // jpa는 트랜잭션 안에서 동작해야한다.
    val tx = entityManager.transaction
    tx.begin()

    try {
        val team = Team(name = "zorba1")
        val team1 = Team(name = "team")
        entityManager.persist(team)
        entityManager.persist(team1)

        for (i in 0 until 30) {
            val address = Address(city = "busan$i", street = "namcheon$i", zipcode = "1234$i")
            entityManager.persist(Member(name = "zorba$i", age = 30+i, homeAddress = address, team = team))
        }

        entityManager.persist(Member(name = "zorba", age = 30, homeAddress = Address(city = "busan", street = "namcheon", zipcode = "123"), team = team1))

        entityManager.flush()
        entityManager.clear()

        val memberNames = entityManager.createQuery(
            "select function('group_concat', m.name) from Member m",
            String::class.java
        ).resultList

        for (member in memberNames) {
            println(">>>>> $member")
        }
        tx.commit()
    } catch (e: Exception) {
        tx.rollback()
    } finally {
        entityManager.close()
    }
    entityManagerFactory.close()
}