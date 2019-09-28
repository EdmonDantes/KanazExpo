package ru.doublegum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.doublegum.entities.Road;
import ru.doublegum.repositories.RoadRepository;

@RestController
@RequestMapping("/api/road")
public class RoadController {

    @Autowired
    private RoadRepository repository;

    @RequestMapping("getBadRoads")
    @ResponseBody
    public String get(@RequestParam double x0, @RequestParam double y0, @RequestParam double x1, @RequestParam double y1) {
        return null;
        // TODO::
    }

    @RequestMapping(path = "add", consumes = "application/json")
    public void add(@RequestBody Road road) {
        repository.save(road);
    }
}
