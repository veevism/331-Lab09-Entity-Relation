package se331.lab.rest.dao;

import org.springframework.data.domain.Pageable;

import java.util.Optional;

import org.springframework.data.domain.Page;

import se331.lab.rest.entity.Organizer;

public interface OrganizerDao {
    Page<Organizer> getOrganizer(Pageable pageRequest);

    Optional<Organizer> findById(Long id);
}