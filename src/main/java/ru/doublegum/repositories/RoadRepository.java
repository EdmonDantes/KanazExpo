package ru.doublegum.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.doublegum.entities.Road;

@Repository
public interface RoadRepository extends CrudRepository<Road, Integer> {}
