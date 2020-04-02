package com.practice

import com.practice.embedded.Address
import com.practice.embedded.Member
import com.practice.embedded.Period
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
        val results = entityManager.createQuery(
            "select m from Member m where m.name like '%zorba%'",
                     Member::class.java
        ).resultList
        println(results)
        tx.commit()
    } catch (e: Exception) {
        tx.rollback()
    } finally {
        entityManager.close()
    }
    entityManagerFactory.close()
}