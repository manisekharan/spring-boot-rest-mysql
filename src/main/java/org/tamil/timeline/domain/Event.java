package org.tamil.timeline.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.UUID;
import javax.persistence.*;
import java.util.*;

@Entity
public class Event {

    @Id
    private Long id;
    private String title = "";
    @Column(columnDefinition = "varchar(1000)")
    private String summary = "";
    private String imageSrc = "";


    public Event() {
    }

    public Event(Long id, String title, String summary, String imageSrc) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.imageSrc = imageSrc;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    @Override
    public String toString() {
        return String.format("Event [id=%s, title=%s, summary=%s, , imageSrc=%s]", id, title, summary, imageSrc);
    }
}