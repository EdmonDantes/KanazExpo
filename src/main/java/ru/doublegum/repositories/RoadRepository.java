package ru.doublegum.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.doublegum.entities.City;
import ru.doublegum.entities.Road;

import java.util.Optional;

@Repository
public interface RoadRepository extends CrudRepository<Road, Integer> {
    Optional<Road> findByCityAndName(City city, String name);
}
