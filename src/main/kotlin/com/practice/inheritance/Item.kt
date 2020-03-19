package com.practice.inheritance

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
open class Item(
    @Id
    @GeneratedValue
    val id: Long = 0,
    val name: String? = null,
    val price: Int? = null
)