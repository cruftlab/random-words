package com.cruftlab.words.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null

    var fullForm: String = ""

    constructor()

    constructor(fullForm: String) {
        this.fullForm = fullForm
    }

    override fun toString(): String {
        return fullForm
    }
}
