package org.tamil.timeline.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.tamil.timeline.common.helper.CSVHelper;
import org.tamil.timeline.data.CSVRepository;
import org.tamil.timeline.domain.Event;

@Service
public class CSVService {
    @Autowired
    CSVRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Event> events = CSVHelper.csvToTutorials(file.getInputStream());
            repository.saveAll(events);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<Event> events = repository.findAll();

        ByteArrayInputStream in = CSVHelper.tutorialsToCSV(events);
        return in;
    }

    public List<Event> getAllEvents() {
        return repository.findAll();
    }
}