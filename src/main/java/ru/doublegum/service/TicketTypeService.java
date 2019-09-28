package ru.doublegum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.doublegum.entities.TicketType;
import ru.doublegum.repositories.TicketTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketTypeService {

    @Autowired
    TicketTypeRepository repository;

    public List<TicketType> getTypes() {
        if (repository != null) {
            return (List<TicketType>) repository.findAll();
        }

        return new ArrayList<>();
    }

    public Optional<TicketType> findById(int id) {
        return repository.findById(id);
    }

    public Optional<TicketType> findByName(String name) {
        return repository.findByName(name);
    }

    public TicketType firstInsert(TicketType type) {
        if (type != null && (type.getId() != null || type.getId() < 1)) {
            return repository.save(type);
        }

        return type;
    }

    public TicketType save(TicketType type) {
        return repository.save(type);
    }

    public void setDeprecated(int id, Boolean bool) { //TODO Void???

        Optional<TicketType> type = repository.findById(id);
        if (type.isPresent()) {
            TicketType tmp = type.get();
            tmp.setDeprecated(bool);
            repository.save(tmp);
        }
    }

}


