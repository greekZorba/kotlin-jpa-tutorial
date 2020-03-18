package com.practice.third.domain

import javax.persistence.*

@Entity
class Category (

    @Id
    @GeneratedValue
    val id: Long = 0,

    val name: String,

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    val parent: Category,

    @OneToMany(mappedBy = "parent")
    val child: List<Category> = ArrayList(),

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
        joinColumns = [JoinColumn(name = "CATEGORY_ID")],
        inverseJoinColumns = [JoinColumn(name = "ITEM_ID")]
    )
    val items: List<Item> = ArrayList()



)