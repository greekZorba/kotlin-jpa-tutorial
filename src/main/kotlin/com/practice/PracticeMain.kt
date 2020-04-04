package com.practice

import com.practice.jpql.Member
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

        entityManager.persist(Member(name = "zorba"))

        entityManager.flush()
        entityManager.clear()

        // Query 타입
        val query = entityManager.createQuery(
            "select m.id, m.name from Member m where m.name = :name"
        ).setParameter("name", "zorba")

        val result = query.singleResult
        println(result.toString())
        tx.commit()
    } catch (e: Exception) {
        tx.rollback()
    } finally {
        entityManager.close()
    }
    entityManagerFactory.close()
}