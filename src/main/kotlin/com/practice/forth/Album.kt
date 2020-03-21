package com.practice.forth

import javax.persistence.Entity

@Entity
class Album (
    val artist: String
) : Item()