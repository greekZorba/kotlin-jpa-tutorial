package com.practice.forth

import javax.persistence.Entity

@Entity
class Movie (
    val director: String,
    val actor: String
) : Item()