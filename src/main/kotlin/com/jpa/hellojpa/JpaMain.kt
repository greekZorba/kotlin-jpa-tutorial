package com.jpa.hellojpa

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Persistence

class JpaMain

fun main(args: Array<String>) {
    val entityManagerFactory = Persistence.createEntityManagerFactory("hello")
    val entityManager = entityManagerFactory.createEntityManager()

    // jpa는 트랜잭션 안에서 동작해야한다.
    val tx = entityManager.transaction
    tx.begin()

    try {
        entityManager.persist(Member(10L, "zorba", 10, RoleType.ADMIN, Date(), Date(), "description"))

        // 자동으로 업데이트 됨
//        findMember.name = "jinhak.kim"
        tx.commit()
    } catch (e: Exception) {
        tx.rollback()
    } finally {
        entityManager.close()
    }
    entityManagerFactory.close()
}
