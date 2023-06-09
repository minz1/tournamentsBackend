package com.minz1.tournamentsbe

import com.minz1.tournamentsbe.model.Participant
import com.minz1.tournamentsbe.repository.ParticipantRepository
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/api/participants")
class ParticipantController(private val participantRepository: ParticipantRepository) {
    @GetMapping("")
    fun getAllParticipants(): ResponseEntity<List<Participant>> = ResponseEntity.ok(participantRepository.findAll())

    @PostMapping("")
    fun createNewParticipant(@Valid @RequestBody participant: Participant): ResponseEntity<Participant> =
        ResponseEntity.ok(participantRepository.save(participant))

    @GetMapping("/{id}")
    fun getParticipantById(@PathVariable(value = "id") participantId: Long): ResponseEntity<Participant> {
        return participantRepository.findById(participantId).map { participant ->
            ResponseEntity.ok(participant)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/{id}")
    fun updateParticipantById(
        @PathVariable(value = "id") participantId: Long,
        @Valid @RequestBody newParticipant: Participant
    ): ResponseEntity<Participant> {
        return participantRepository.findById(participantId).map { existingParticipant ->
            val updatedParticipant: Participant = existingParticipant
                .copy(
                    name = newParticipant.name,
                    email = newParticipant.email,
                    phoneNumber = newParticipant.phoneNumber
                )
            ResponseEntity.ok().body(participantRepository.save(updatedParticipant))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deleteParticipantById(@PathVariable(value = "id") participantId: Long): ResponseEntity<Void> {
        return participantRepository.findById(participantId).map { participant ->
            participantRepository.delete(participant)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}
