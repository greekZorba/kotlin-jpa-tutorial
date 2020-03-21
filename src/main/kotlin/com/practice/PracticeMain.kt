package com.practice

import com.practice.forth.Book
import com.practice.inheritance.Album
import com.practice.inheritance.BaseEntity
import com.practice.inheritance.Item
import com.practice.inheritance.Member
import java.time.LocalDateTime
import javax.persistence.Persistence

class PracticeMain

fun main(args: Array<String>) {
    val entityManagerFactory = Persistence.createEntityManagerFactory("practice")
    val entityManager = entityManagerFactory.createEntityManager()

    // jpa는 트랜잭션 안에서 동작해야한다.
    val tx = entityManager.transaction
    tx.begin()

    try {

        val book = Book(author = "Zorba", isbn = "d")
        book.name = "zorba"

        entityManager.persist(book)

        tx.commit()
    } catch (e: Exception) {
        tx.rollback()
    } finally {
        entityManager.close()
    }
    entityManagerFactory.close()
}