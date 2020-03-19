package com.practice

import com.practice.inheritance.Album
import com.practice.inheritance.Item
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
        val item = Item(name = "zorba", price = 1000)
        val album = Album(artist = "IU")
        entityManager.persist(item)
        entityManager.persist(album)

        entityManager.flush()
        entityManager.clear()

        val findItem = entityManager.find(Item().javaClass, item.id)
        println(">>>>>>>>>> ${findItem.name}")

        tx.commit()
    } catch (e: Exception) {
        tx.rollback()
    } finally {
        entityManager.close()
    }
    entityManagerFactory.close()
}