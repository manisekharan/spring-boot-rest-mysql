package org.tamil.timeline.webapp;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.tamil.timeline.domain.Event;
import org.tamil.timeline.service.EventService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/timeline/v1")
public class EventController {
    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents() {
        try{
            logger.info("\n----Calling EventController.getAllEvents()----");
            return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/events/{eventId}")
    public ResponseEntity<Event> getEvent(@PathVariable Long eventId){
        try {
            return new ResponseEntity<>(eventService.getEvent(eventId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/events")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        try {
            return new ResponseEntity<>(eventService.addEvent(event), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/events/{eventId}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long eventId, @RequestBody Event event) {
        try{
            return new ResponseEntity<>(eventService.updateEvent(eventId, event), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/events/{eventId}")
    public ResponseEntity<HttpStatus> deleteEvent(@PathVariable Long eventId) {
        try {
            eventService.deleteEvent(eventId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}