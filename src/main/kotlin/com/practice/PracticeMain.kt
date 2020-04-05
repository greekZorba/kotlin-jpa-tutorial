package com.practice

import com.practice.paging.Address
import com.practice.paging.Member
import com.practice.paging.Team
import java.time.LocalDateTime
import javax.persistence.Persistence

class PracticeMain

fun main() {
    val entityManagerFactory = Persistence.createEntityManagerFactory("practice")
    val entityManager = entityManagerFactory.createEntityManager()

    // jpa는 트랜잭션 안에서 동작해야한다.
    val tx = entityManager.transaction
    tx.begin()

    try {
        val team = Team(name = "development")
        entityManager.persist(team)

        for (i in 0 until 30) {
            val address = Address(city = "busan$i", street = "namcheon$i", zipcode = "1234$i")
            entityManager.persist(Member(name = "zorba$i", age = 30+i, homeAddress = address, team = team))
        }

        entityManager.flush()
        entityManager.clear()

        val members = entityManager.createQuery(
            "select m from Member m order by m.age desc",
            Member::class.java
        ).setFirstResult(1)
            .setMaxResults(20)
            .resultList

        for(member in members) {
            println("결과 값 : ${member.age}")
        }

        tx.commit()
    } catch (e: Exception) {
        tx.rollback()
    } finally {
        entityManager.close()
    }
    entityManagerFactory.close()
}