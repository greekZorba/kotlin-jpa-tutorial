package com.practice

import com.practice.second.domain.Locker
import com.practice.second.domain.Member
import com.practice.second.domain.Team
import javax.persistence.Persistence

class PracticeMain

fun main(args: Array<String>) {
    val entityManagerFactory = Persistence.createEntityManagerFactory("practice")
    val entityManager = entityManagerFactory.createEntityManager()

    // jpa는 트랜잭션 안에서 동작해야한다.
    val tx = entityManager.transaction
    tx.begin()

    try {
        val team = Team()
        team.name = "Team1"
        entityManager.persist(team)

        val locker = Locker(name = "zorba")
        entityManager.persist(locker)

        val member = Member(name = "zorba", city = "busan", team = team, street = "namcheon st", locker = locker, zipcode = "1234")
        entityManager.persist(member)


//        team.addMember(member)

//        val findMember = entityManager.find(member.javaClass, member.id)
//        println("findMember : $findMember")
        tx.commit()
    } catch (e: Exception) {
        tx.rollback()
    } finally {
        entityManager.close()
    }
    entityManagerFactory.close()
}