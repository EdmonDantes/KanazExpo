package ru.doublegum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.doublegum.entities.Ticket;
import ru.doublegum.repositories.TicketRepository;

import java.util.List;
import java.util.Optional;

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

    public List<Ticket> findAllByXBetweenAndYBetween(double x0, double y0, double x1, double y1) {
        return repository.findAllByXBetweenAndYBetween(x0, x1, y0, y1);
    }

    public Optional<Ticket> findById(Integer id) {
        return repository.findById(id);
    }
}
