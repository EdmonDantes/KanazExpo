package ru.doublegum.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/problem")
public class RoadProblemController {

    @RequestMapping(value = "/add", consumes = "application/json", method = RequestMethod.POST)
    public String add(){}
}
