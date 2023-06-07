package com.minz1.tournamentsbe

import com.minz1.tournamentsbe.model.Participant
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ParticipantController {
    @GetMapping("/participant")
    fun participant(
        @RequestParam(value = "name", defaultValue = "John Doe") name: String,
        @RequestParam(value = "email", defaultValue = "johhdoe@email.com") email: String,
        @RequestParam(value = "phone_number", defaultValue = "123-456-7890") phoneNumber: String
    ): Participant {
        return Participant(name, email, phoneNumber)
    }
}
