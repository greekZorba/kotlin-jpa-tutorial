package com.practice.forth

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn // 기본이 DTYPE
open abstract class Item(
    @Id
    @GeneratedValue
    val id: Long = 0,
    var name: String? = null,
    var price: Int? = null
) : BaseEntity()