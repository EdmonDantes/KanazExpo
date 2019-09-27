package ru.doublegum.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.doublegum.entityes.GeoPoint;
import ru.doublegum.entityes.Road;

import java.util.List;

public interface RoadRepository extends CrudRepository<Road, Integer> {
    List<Road> findAllByStartXBetweenAndStartYBetweenOrEndXBetweenAndEndYBetween(double startXMin, double startXMax, double startYMin, double startYMax, double endXMin, double endXMax, double endYMin, double endYMax);
}
