package ru.doublegum.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.doublegum.entities.TicketType;

import java.util.Optional;

@Repository
public interface TicketTypeRepository extends CrudRepository<TicketType, Integer> {
    Optional<TicketType> findByName(String name);
}
