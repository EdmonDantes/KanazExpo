package ru.doublegum.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.doublegum.entities.TicketStatus;

@Repository
public interface TicketStatusRepository extends CrudRepository<TicketStatus, Integer> {
}
