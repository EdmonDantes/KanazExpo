package ru.doublegum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.doublegum.entities.City;
import ru.doublegum.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CItyController {

    @Autowired
    private CityService cityService;

    @RequestMapping(path = "/getBy/id", method = RequestMethod.GET)
    @ResponseBody
    public City getById(@RequestParam Integer id) {
        return cityService.findCityById(id).orElse(null);
    }

    @RequestMapping(path = "/getBy/locationId", method = RequestMethod.GET)
    @ResponseBody
    public City getByLocationId(@RequestParam String locationId) {
        return cityService.findCityByLocationId(locationId).orElse(null);
    }

    @RequestMapping(path = "/getAllBy/name", method = RequestMethod.GET)
    @ResponseBody
    public List<City> getAllByName(@RequestParam String name) {
        return cityService.findCitiesByName(name);
    }
}
