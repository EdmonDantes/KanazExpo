package ru.doublegum.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.doublegum.entities.Road;

public interface RoadRepository extends CrudRepository<Road, Integer> {}
