package com.jpa.hellojpa

import javax.persistence.Persistence

class JpaMain

fun main(args: Array<String>) {
    val entityManagerFactory = Persistence.createEntityManagerFactory("hello")
    val entityManager = entityManagerFactory.createEntityManager()

    // jpa는 트랜잭션 안에서 동작해야한다.
    val tx = entityManager.transaction
    tx.begin()

    try {
        val member = Member(id=2, name="초콜렛")
        entityManager.persist(member)
        tx.commit()
    } catch (e: Exception) {
        tx.rollback()
    } finally {
        entityManager.close()
    }
    entityManagerFactory.close()
}
