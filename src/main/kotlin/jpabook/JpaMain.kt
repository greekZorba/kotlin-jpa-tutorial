package jpabook

import jpabook.jpashop.domain.Member
import jpabook.jpashop.domain.Team
import javax.persistence.Persistence

fun main() {
    val entityManagerFactory = Persistence.createEntityManagerFactory("hello")
    val entityManager = entityManagerFactory.createEntityManager()

    // jpa는 트랜잭션 안에서 동작해야한다.
    val tx = entityManager.transaction
    tx.begin()

    try {
        val team = Team()
        team.name = "Team1"
        entityManager.persist(team)

        val member = Member(name = "zorba", city = "busan", team = team, street = "namcheon st", zipcode = "1234")
        entityManager.persist(member)

        team.addMember(member)

        val findMember = entityManager.find(member.javaClass, member.id)
        println("findMember : $findMember")
        tx.commit()
    } catch (e: Exception) {
        tx.rollback()
    } finally {
        entityManager.close()
    }
    entityManagerFactory.close()
}