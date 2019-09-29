package ru.doublegum.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.doublegum.entities.Ticket;
import ru.doublegum.entities.TicketStatus;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {

    List<Ticket> findAllByXBetweenAndYBetween(double x0, double x1, double y0, double y1);
    List<Ticket> getAll();
    List<Ticket> findAllByStatus(TicketStatus status);
}
