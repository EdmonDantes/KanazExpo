package ru.doublegum.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.doublegum.entities.City;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends CrudRepository<City, Integer> {

    Optional<City> findByLocationId(String locationId);
    List<City> findByName(String name);

}
