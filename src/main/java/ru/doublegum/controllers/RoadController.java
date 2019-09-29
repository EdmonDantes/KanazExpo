package ru.doublegum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.doublegum.entities.City;
import ru.doublegum.entities.Road;
import ru.doublegum.service.CityService;
import ru.doublegum.service.RoadService;

import java.util.Set;

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
    public Set<Road> getAllByCity(@RequestParam Integer cityId) {
        return cityService.findCityById(cityId).orElse(new City()).getRoads();
    }

    @RequestMapping(path = "/getBy/id", method = RequestMethod.GET)
    @ResponseBody
    public Road getById(@RequestParam Integer id) {
        return roadService.findById(id).orElse(null);
    }
}
