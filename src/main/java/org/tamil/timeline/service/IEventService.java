package org.tamil.timeline.service;

import java.util.List;
import org.tamil.timeline.domain.Event;

public interface IEventService {
    public List getAllEvents();
    public Event getEvent(Long id);
    public Event addEvent(Event event);
    public Event updateEvent(Long id, Event event);
    public void deleteEvent(Long id);
}
