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

        val member = Member(name = "zorba", workPeriod = Period(LocalDateTime.now(), LocalDateTime.now().plusHours(3)), homeAddress = Address(city = "busan", street = "namcheon", zipcode = "1234"))
        entityManager.persist(member)

        entityManager.flush()
        entityManager.clear()

        val findMember = entityManager.find(Member::class.java, member.id)
        println("isWorking now ? ${findMember.workPeriod.isWorking}")

        tx.commit()
    } catch (e: Exception) {
        tx.rollback()
    } finally {
        entityManager.close()
    }
    entityManagerFactory.close()
}