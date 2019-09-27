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

    public RoadProblem firstInsert(RoadProblem problem) {
        if (problem != null)
            if (problem.getId() != null)
                return problem;
            else
                return repository.save(problem);
        return null;
    }

    public RoadProblem save(RoadProblem problem) {
        return repository.save(problem);
    }
}
