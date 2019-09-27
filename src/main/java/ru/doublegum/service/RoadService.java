package ru.doublegum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.doublegum.entityes.Road;
import ru.doublegum.entityes.RoadProblem;
import ru.doublegum.repositories.RoadRepository;

import java.util.Optional;

@Service
public class RoadService {

    @Autowired
    private RoadRepository repository;

    @Autowired
    private RoadProblemService roadProblemService;

    public boolean addProblem(int idRoad, RoadProblem problem) {
        problem = roadProblemService.save(problem);

        if (problem != null) {
            Optional<Road> road  = repository.findById(idRoad);
            if (road.isPresent()) {
                Road tmp = road.get();
                tmp.getProblems().add(problem);
                repository.save(tmp);
                return true;
            }
        }
        return false;
    }
}
