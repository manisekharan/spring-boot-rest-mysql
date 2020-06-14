package org.tamil.timeline.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.tamil.timeline.data.EventRepository;
import org.tamil.timeline.domain.Event;

@Service
public class EventService implements IEventService {

    @Autowired
    private EventRepository eventRepository;

    public List getAllEvents() {
        List books = new ArrayList<>();
        eventRepository.findAll().forEach(books::add);
        return books;
    }

    public Event getEvent(Long id) {
        return eventRepository.findById(id).orElseGet(Event::new);
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
