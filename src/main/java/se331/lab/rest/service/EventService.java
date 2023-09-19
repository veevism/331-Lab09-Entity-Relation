package se331.lab.rest.service;

import java.util.List;

import org.springframework.data.domain.Page;

import se331.lab.rest.entity.Event;

public interface EventService {
    Integer getEventSize();

    Page<Event> getEvents(Integer pageSize, Integer page);

    Event getEvent(Long id);

    Event save(Event event);
}