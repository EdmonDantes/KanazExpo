package ru.doublegum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.doublegum.entityes.GeoPoint;
import ru.doublegum.repositories.GeoPointRepository;

@Service
public class GeoPointService {

    @Autowired
    private GeoPointRepository repository;

    public GeoPoint save(GeoPoint point) {
        if (point != null) {
            if (point.getId() != null)
                return repository.save(point);
        }
        return point;
    }

}
