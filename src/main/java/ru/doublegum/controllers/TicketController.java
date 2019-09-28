package ru.doublegum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.doublegum.HereApi;
import ru.doublegum.entities.City;
import ru.doublegum.entities.Road;
import ru.doublegum.entities.Ticket;
import ru.doublegum.entities.TicketType;
import ru.doublegum.repositories.TicketTypeRepository;
import ru.doublegum.service.CityService;
import ru.doublegum.service.RoadService;
import ru.doublegum.service.TicketService;
import ru.doublegum.service.TicketStatusService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    RoadService roadService;

    @Autowired
    CityService cityService;

    @Autowired
    TicketStatusService ticketStatusService;

    @Autowired
    TicketTypeRepository ticketTypeRepository;

    @Autowired
    TicketService ticketService;

    @RequestMapping(value = "/add", consumes = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody double x, @RequestBody double y, @RequestBody int typeId, @RequestBody String description, @RequestBody byte[] picture){
        try {
            Map<String, String> address = HereApi.getAddressFromPoint(x, y);
            if (address.containsKey("country") && address.containsKey("city")) {
                Map<String, String> data = new HashMap<>();
                data.put("country", address.get("country"));
                data.put("city", address.get("city"));
                String locationId = HereApi.getLocationId(data);
                Optional<City> tmp0 = cityService.findCityFromLocationId(locationId);
                if (!tmp0.isPresent()) {
                    City tmp = new City();
                    tmp.setLocationId(locationId);
                    tmp.setName(address.get("city"));
                    tmp0 = Optional.of(cityService.save(tmp));
                }
                Optional<Road> roadOptional = roadService.findByCityAndName(tmp0.get(), address.get("street"));

                if (!roadOptional.isPresent()) {
                    Road road = new Road();
                    road.setName(address.get("street"));
                    road.setCount(0);
                    road.setSum(0);
                    roadOptional = Optional.of(roadService.save(road));
                    cityService.addRoad(tmp0.get().getId(), roadOptional.get());
                }

                Ticket ticket = new Ticket();
                ticket.setX(x);
                ticket.setY(y);
                ticket.setDescription(description);
                ticket.setPicture(picture);
                ticket.setStatus(ticketStatusService.getFirstStatus());

                Optional<TicketType> type = ticketTypeRepository.findById(typeId);

                if (type.isPresent()) {
                    ticket.setType(type.get());
                    roadService.addProblem(roadOptional.get().getId(), ticketService.save(ticket));
                    return "Success";
                } else
                    return "Wrong type id";
            }
            return "It is not city";
        } catch (IOException e) {
            return "Wrong coordinates";
        }
    }

    @RequestMapping(path = "/type/add", method = RequestMethod.POST, consumes = "applcation/json")
    @ResponseBody
    public String addTicketType(@RequestBody String name, @RequestBody double weight) {

    }
}
