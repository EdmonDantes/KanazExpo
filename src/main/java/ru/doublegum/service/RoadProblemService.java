package ru.doublegum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.reactive.ReactiveOAuth2ClientAutoConfiguration;
import org.springframework.stereotype.Service;
import ru.doublegum.entityes.RoadProblem;
import ru.doublegum.repositories.RoadProblemRepository;

@Service
public class RoadProblemService {

    @Autowired
    private RoadProblemRepository repository;

    public Ticket firstInsert(Ticket problem) {
        if (problem != null && (problem.getId() == null || problem.getId() < 1))
            return repository.save(problem);
        return problem;
    }

    public Ticket save(Ticket problem) {
        return repository.save(problem);
    }
}
