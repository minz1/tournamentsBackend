package com.minz1.tournamentsbe.repository

import com.minz1.tournamentsbe.model.Participant
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParticipantRepository : JpaRepository<Participant, Long>