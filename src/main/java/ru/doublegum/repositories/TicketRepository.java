package ru.doublegum.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.doublegum.entities.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {

}
