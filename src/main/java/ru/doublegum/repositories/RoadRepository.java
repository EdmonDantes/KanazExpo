package ru.doublegum.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.doublegum.entityes.Road;

public interface RoadRepository extends CrudRepository<Road, Integer> {
}
