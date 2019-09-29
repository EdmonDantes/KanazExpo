package ru.doublegum.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/testMap")
public class MapController {

    @RequestMapping(value = "getBadStreet", method = RequestMethod.GET)
    @ResponseBody
    public String getBadStreet(@RequestParam double x0, @RequestParam double y0, @RequestParam double x1, @RequestParam double y1) {
        // TODO: get data from db
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("start_x", new JsonPrimitive((x0 + x1) / 2 - (x0 + x1) / 5));
        jsonObject.add("start_y", new JsonPrimitive((y0 + y1) / 2 - (y0 + y1) / 5));
        jsonObject.add("end_x", new JsonPrimitive((x0 + x1) / 2 + (x0 + x1) / 5));
        jsonObject.add("end_x", new JsonPrimitive((y0 + y1) / 2 + (y0 + y1) / 5));
        jsonObject.add("problems", new JsonPrimitive(80));
        JsonArray array = new JsonArray();
        array.add(jsonObject);
        return array.toString();
    }
}
