package se331.lab.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import se331.lab.rest.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAll();
}