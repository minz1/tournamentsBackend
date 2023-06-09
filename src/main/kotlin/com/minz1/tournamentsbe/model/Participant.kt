package com.minz1.tournamentsbe.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank

@Entity
data class Participant(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @get: NotBlank
    var name: String = "",
    @get: NotBlank
    var email: String = "",
    var phoneNumber: String = "",
)
