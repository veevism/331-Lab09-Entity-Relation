package se331.lab.rest.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import se331.lab.rest.entity.Event;
import se331.lab.rest.service.EventService;
import se331.lab.rest.util.LabMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor

public class EventController {
    final EventService eventService;

    @GetMapping("event")
    public ResponseEntity<?> getEventLists(@RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page) {
        Page<Event> pageOutput = eventService.getEvents(perPage, page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getEventDto(pageOutput.getContent()), responseHeader,
                HttpStatus.OK);

    }

    @GetMapping("event/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Event output = eventService.getEvent(id);

        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getEventDto(output));

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/event")
    public ResponseEntity<?> addEvent(@RequestBody Event event) {
        Event output = eventService.save(event);
        return ResponseEntity.ok(LabMapper.INSTANCE.getEventDto(output));
    }
}
