package ru.doublegum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.doublegum.entities.Ticket;
import ru.doublegum.repositories.RoadProblemRepository;

@Service
public class RoadProblemService {

    @Autowired
    private RoadProblemRepository repository;

    public Ticket firstInsert(Ticket problem) {
        if (problem != null)
            if (problem.getId() != null)
                return problem;
            else
                return repository.save(problem);
        return null;
    }

    public Ticket save(Ticket problem) {
        return repository.save(problem);
    }
}
