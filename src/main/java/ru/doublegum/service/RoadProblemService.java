package ru.doublegum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.doublegum.entityes.RoadProblem;
import ru.doublegum.repositories.RoadProblemRepository;

@Service
public class RoadProblemService {

    @Autowired
    private RoadProblemRepository repository;

    public RoadProblem firstInsert(RoadProblem problem) {
        if (problem != null && (problem.getId() == null || problem.getId() < 1))
            return repository.save(problem);
        return problem;
    }

    public RoadProblem save(RoadProblem problem) {
        return repository.save(problem);
    }
}
