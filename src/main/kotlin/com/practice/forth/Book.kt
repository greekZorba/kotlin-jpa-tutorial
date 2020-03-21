package com.practice.forth

import javax.persistence.Entity

@Entity
class Book (
    val author: String,
    val isbn: String
) : Item()