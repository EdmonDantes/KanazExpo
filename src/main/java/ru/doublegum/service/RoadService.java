package ru.doublegum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.doublegum.entities.Road;
import ru.doublegum.entities.Ticket;
import ru.doublegum.repositories.RoadRepository;

import java.util.Optional;

@Service
public class RoadService {

    @Autowired
    private RoadRepository repository;

    @Autowired
    private RoadProblemService roadProblemService;

    public Road firstInsert(Road road) {
        if (road != null && (road.getId() == null || road.getId() < 1))
            return repository.save(road);
        return road;
    }

    public Road save(Road road) {
        return repository.save(road);
    }

    public boolean addProblem(int idRoad, Ticket problem) {
        problem = roadProblemService.firstInsert(problem);

        if (problem != null) {
            Optional<Road> road  = repository.findById(idRoad);
            if (road.isPresent()) {
                Road tmp = road.get();
                tmp.getTickets().add(problem);
                repository.save(tmp);
                return true;
            }
        }
        return false;
    }

//    public boolean deleteProblem(Integer id) {
//
//    }
}
