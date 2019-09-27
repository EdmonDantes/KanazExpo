package ru.doublegum.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.doublegum.entityes.RoadProblem;

@Repository
public interface RoadProblemRepository extends CrudRepository<RoadProblem, Integer> {
}
