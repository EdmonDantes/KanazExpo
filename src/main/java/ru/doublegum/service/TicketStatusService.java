package ru.doublegum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.doublegum.entities.TicketStatus;
import ru.doublegum.repositories.TicketStatusRepository;

@Service
public class TicketStatusService {

    @Autowired
    private TicketStatusRepository repository;

    public TicketStatus getCreatedStatus(){
        return repository.findById(1).orElse(null);
    }
}
