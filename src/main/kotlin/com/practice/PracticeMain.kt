package com.practice

import com.practice.jpql.Address
import com.practice.jpql.Member
import com.practice.jpql.MemberDto
import com.practice.jpql.Team
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
        val address = Address(city = "busan", street = "namcheon", zipcode = "1234")
        val team = Team(name = "development")
        entityManager.persist(team)
        entityManager.persist(Member(name = "zorba", age = 30, homeAddress = address, team = team))

        entityManager.flush()
        entityManager.clear()

        // Query 타입
        val query = entityManager.createQuery(
            "select new com.practice.jpql.MemberDto(m.name, m.age) from Member m where m.name = :name",
            MemberDto::class.java
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