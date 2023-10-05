package se331.lab.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.service.OrganizerService;

@RestController
@RequiredArgsConstructor
public class OrganizerController {
    final OrganizerService organizerService;

    @GetMapping("/organizers")
    ResponseEntity<List<Organizer>> getOrganizers() {
        List<Organizer> organizers = organizerService.getAllOrganizer();
        return ResponseEntity.ok(organizers);
    }
}