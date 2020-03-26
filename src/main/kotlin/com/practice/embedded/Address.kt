package com.practice.embedded

import javax.persistence.Embeddable

@Embeddable
data class Address (
    var city: String,
    var street: String,
    var zipcode: String
)