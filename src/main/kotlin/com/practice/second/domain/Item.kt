package com.practice.second.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Item (
        @Id
        @GeneratedValue
        @Column(name="ITEM_ID")
        val id: Long,
        val name: String,
        val price: Int,
        val stockQuantity: Int
)