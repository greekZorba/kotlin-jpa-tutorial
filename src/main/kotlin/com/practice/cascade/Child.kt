package com.practice.cascade

import javax.persistence.*

@Entity
class Child(

    @Id
    @GeneratedValue
    val id: Long = 0,

    var name: String? = null,

    @ManyToOne
    @JoinColumn(name = "parent_id")
    var parent: Parent? = null
)