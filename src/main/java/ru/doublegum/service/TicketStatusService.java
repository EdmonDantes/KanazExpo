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

    public TicketStatus getCheckedStatus() { return repository.findById(2).orElse(null); }

    public TicketStatus getStartedStatus(){
        return repository.findById(3).orElse(null);
    }

    public TicketStatus getEndedStatus() { return repository.findById(4).orElse(null); }

    public TicketStatus getClosedStatus(){
        return repository.findById(5).orElse(null);
    }

}
