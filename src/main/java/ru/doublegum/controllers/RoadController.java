package ru.doublegum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.doublegum.entities.City;
import ru.doublegum.entities.Road;
import ru.doublegum.service.CityService;
import ru.doublegum.service.RoadService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/road")
public class RoadController {

    private final RoadService roadService;

    private final CityService cityService;

    @Autowired
    public RoadController(RoadService roadService, CityService cityService) {
        this.roadService = roadService;
        this.cityService = cityService;
    }

    @RequestMapping(path = "/getAllBy/city", method = RequestMethod.GET)
    @ResponseBody
    public List<Road> getAllByCity(@RequestParam Integer cityId) {
        Optional<City> city = cityService.findCityById(cityId);
        if (city.isPresent()) {
            return roadService.findAllByCity(city.get());
        }
        return Collections.EMPTY_LIST;
    }

    @RequestMapping(path = "/getBy/id", method = RequestMethod.GET)
    @ResponseBody
    public Road getById(@RequestParam Integer id) {
        return roadService.findById(id).orElse(null);
    }
}
