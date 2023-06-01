package com.minz1.tournamentsbackend;

import com.minz1.tournamentsbackend.model.Participant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParticipantController {

    @GetMapping("/participant")
    public Participant participant(@RequestParam(value="name", defaultValue = "John Doe") String name,
                                   @RequestParam(value="email", defaultValue = "johhdoe@email.com") String email,
                                   @RequestParam(value="phone_number", defaultValue = "123-456-7890") String phoneNumber) {
        return new Participant(name, email, phoneNumber);
    }
}
