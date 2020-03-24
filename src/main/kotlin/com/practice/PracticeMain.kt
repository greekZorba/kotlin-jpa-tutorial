package com.practice

import com.practice.cascade.Child
import com.practice.cascade.Parent
import com.practice.forth.Book
import com.practice.inheritance.Album
import com.practice.inheritance.BaseEntity
import com.practice.inheritance.Item
import com.practice.inheritance.Member
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
        val child1 = Child(name = "zorba son")
        val child2 = Child(name = "zorba daughter")

        val parent = Parent(name = "zorba")
        parent.addChild(child1)
        parent.addChild(child2)

        entityManager.persist(parent)

        entityManager.flush()
        entityManager.clear()

        val findParent = entityManager.find(Parent::class.java, parent.id)
        findParent.children?.removeAt(0)
        tx.commit()
    } catch (e: Exception) {
        tx.rollback()
    } finally {
        entityManager.close()
    }
    entityManagerFactory.close()
}