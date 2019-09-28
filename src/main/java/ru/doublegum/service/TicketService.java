package ru.doublegum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.doublegum.entities.Ticket;
import ru.doublegum.repositories.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;

    public Ticket firstInsert(Ticket ticket) {
        if (ticket != null && (ticket.getId() == null || ticket.getId() < 1))
            return repository.save(ticket);
        return ticket;
    }

    public Ticket save(Ticket ticket) {
        return repository.save(ticket);
    }
}
