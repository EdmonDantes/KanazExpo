package ru.doublegum.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/problem")
public class RoadProblemController {

    @RequestMapping(value = "/add", consumes = "application/json", method = RequestMethod.POST)
    public String add(@RequestBody double x, @RequestBody double y, @RequestBody String type){
        return null;
        //TODO:
    }
}
