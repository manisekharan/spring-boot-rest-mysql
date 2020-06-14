package org.tamil.timeline.data;

import org.springframework.data.jpa.repository.JpaRepository;

import org.tamil.timeline.domain.Event;

public interface CSVRepository extends JpaRepository<Event, Long> {
}