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

    public Road firstInsert(Road road) {
        if (road != null){
            if (road.getId() != null)
                return repository.save(road);
        }
        return road;
    }

    public Road save(Road road) {
        return repository.save(road);
    }

    public boolean addProblem(int idRoad, RoadProblem problem) {
        problem = roadProblemService.firstInsert(problem);

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
