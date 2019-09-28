package ru.doublegum.controllers;

import org.springframework.web.bind.annotation.*;
import ru.doublegum.HereApi;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/problem")
public class RoadProblemController {

    @RequestMapping(value = "/add", consumes = "application/json", method = RequestMethod.POST)
    public String add(@RequestBody double x, @RequestBody double y, @RequestBody String type){
        try {
            Map<String, String> address = HereApi.getAddressFromPoint(x, y);

        } catch (IOException e) {
            return "Wrong coordinates";
        }
        return "Server is wrong";
    }
}
