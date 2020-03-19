package com.practice.third.domain

import javax.persistence.*

@Entity
data class Item (
        @Id
        @GeneratedValue
        @Column(name="ITEM_ID")
        val id: Long,
        val name: String,
        val price: Int,
        val stockQuantity: Int,

        @ManyToMany(mappedBy = "items")
        val categories: List<Category> = ArrayList()
)