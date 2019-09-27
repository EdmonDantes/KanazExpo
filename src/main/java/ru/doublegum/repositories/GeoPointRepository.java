package ru.doublegum.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.doublegum.entityes.GeoPoint;

@Repository
public interface GeoPointRepository extends CrudRepository<GeoPoint, Integer> {
}
