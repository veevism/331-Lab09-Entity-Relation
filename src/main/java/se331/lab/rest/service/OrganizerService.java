package se331.lab.rest.service;

import java.util.List;

import org.springframework.data.domain.Page;

import se331.lab.rest.entity.Organizer;

public interface OrganizerService {
    List<Organizer> getAllOrganizer();

    Page<Organizer> getOrganizer(Integer page, Integer pageSize);
}