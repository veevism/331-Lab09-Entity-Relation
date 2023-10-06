package se331.lab.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

}