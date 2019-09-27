package ru.doublegum.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.doublegum.entityes.Road;
import ru.doublegum.repositories.RoadRepository;

@RestController
@RequestMapping("/api/road")
public class RoadController {

    @Autowired
    private RoadRepository repository;

    @RequestMapping("getBadRoads")
    @ResponseBody
    public String get(@RequestParam double x0, @RequestParam double y0, @RequestParam double x1, @RequestParam double y1) {
        JsonArray array = new JsonArray();

        for (Road road : repository.findAllByStartXBetweenAndStartYBetweenOrEndXBetweenAndEndYBetween(x0, x1, y0, y1, x0, x1, y0, y1)) {
            array.add(road.toJson());
        }

        return array.toString();
    }

    @RequestMapping(path = "add", consumes = "application/json")
    public void add(@RequestBody Road road) {
        repository.save(road);
    }
}
