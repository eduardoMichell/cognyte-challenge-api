package br.edu.event_manager.repository;

import br.edu.event_manager.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}