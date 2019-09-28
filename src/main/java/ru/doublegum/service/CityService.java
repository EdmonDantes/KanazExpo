package ru.doublegum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.doublegum.entities.City;
import ru.doublegum.entities.Road;
import ru.doublegum.repositories.CityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private RoadService roadService;

    @Autowired
    private CityRepository repository;

    public City firstInsert(City city) {
        if (city != null && (city.getId() == null || city.getId() < 1))
            return repository.save(city);
        return city;
    }

    public City save(City city) {
        return repository.save(city);
    }

    public Optional<City> getCityFromId(int id) {
        return repository.findById(id);
    }

    public Optional<City> getCityFromLocationId(String locationId) {
        return repository.findByLocationId(locationId);
    }

    public List<City> getCitiesFromName(String name) {
        return repository.findByName(name);
    }

    public boolean addRoad(int id, Road road) {
        Road tmp0 = roadService.firstInsert(road);

        Optional<City> city = repository.findById(id);
        if (city.isPresent()){
            City tmp = city.get();
            tmp.getRoads().add(tmp0);
            repository.save(tmp);
            return true;
        }
        return false;

    }
}
