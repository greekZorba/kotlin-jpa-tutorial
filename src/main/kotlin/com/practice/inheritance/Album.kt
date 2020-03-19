package com.practice.inheritance

import javax.persistence.Entity

@Entity
class Album (
    val artist: String
) : Item()