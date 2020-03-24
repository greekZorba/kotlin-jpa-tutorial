package com.practice.cascade

import javax.persistence.*

@Entity
class Parent (

    @Id
    @GeneratedValue
    val id: Long = 0,

    var name: String? = null,

    @OneToMany(mappedBy = "parent", cascade = [CascadeType.ALL], orphanRemoval = true)
    var children: MutableList<Child>? = ArrayList()
) {
    fun addChild(child: Child) {
        children?.add(child)
        child.parent = this
    }
}