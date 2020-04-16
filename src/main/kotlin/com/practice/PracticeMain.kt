package com.practice

import com.practice.namedQuery.Address
import com.practice.namedQuery.Member
import com.practice.namedQuery.Team
import javax.persistence.Persistence

class PracticeMain

fun main() {
    val entityManagerFactory = Persistence.createEntityManagerFactory("practice")
    val entityManager = entityManagerFactory.createEntityManager()

    // jpa는 트랜잭션 안에서 동작해야한다.
    val tx = entityManager.transaction
    tx.begin()

    try {
        val teamA = Team(name = "zorba1")
        val teamB = Team(name = "zorba2")
        val teamC = Team(name = "zorba3")
        entityManager.persist(teamA)
        entityManager.persist(teamB)
        entityManager.persist(teamC)

        for (i in 0 until 30) {
            val address = Address(city = "busan$i", street = "namcheon$i", zipcode = "1234$i")
            when {
                i < 10 -> {
                    val member = Member(
                        name = "zorba$i",
                        age = 30 + i,
                        homeAddress = address,
                        team = teamA
                    )
                    entityManager.persist(member)
                    teamA.addMember(member)
                }
                i < 20 -> {
                    val member = Member(
                        name = "zorba$i",
                        age = 30 + i,
                        homeAddress = address,
                        team = teamB
                    )
                    entityManager.persist(member)
                    teamB.addMember(member)
                }
                else -> {
                    val member = Member(
                        name = "zorba$i",
                        age = 30 + i,
                        homeAddress = address,
                        team = teamC
                    )
                    entityManager.persist(member)
                    teamC.addMember(member)
                }
            }


        }

        entityManager.flush()
        entityManager.clear()

        val members = entityManager.createNamedQuery("Member.findByName", Member::class.java)
            .setParameter("name", "zorba10")
            .resultList

        for (member in members) {
            println("member name : $member")
        }
//        for (team in teams) {
//            println(">>>>> ${team}")
//        }
        tx.commit()
    } catch (e: Exception) {
        tx.rollback()
    } finally {
        entityManager.close()
    }
    entityManagerFactory.close()
}