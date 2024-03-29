package ru.doublegum.controllers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.doublegum.HereApi;
import ru.doublegum.entities.*;
import ru.doublegum.repositories.TicketTypeRepository;
import ru.doublegum.service.CityService;
import ru.doublegum.service.RoadService;
import ru.doublegum.service.TicketService;
import ru.doublegum.service.TicketStatusService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

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

    //    @ModelAttribute
    //    public void attributes(HttpServletResponse response){
    //        // TODO :delete in production
    //        response.setHeader("Access-Control-Allow-Origin", "*");
    //        response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
    //        response.setHeader("Access-Control-Allow-Headers", "X_PINGOTHER, Content-Type");
    //        response.setHeader("Access-Control-Max-Age","86400");
    //    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Ticket> getAll() {return ticketService.getAll(); }

    @RequestMapping(value = "/getAllBy/status", method = RequestMethod.GET)
    @ResponseBody
    public List<Ticket> getAllByStatus(@RequestParam Integer statusId) {
        TicketStatus status = ticketStatusService.getById(statusId);
        return ticketService.findAllByStatus(status);
    }


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Ticket get(@RequestParam Integer id) {
        return ticketService.findById(id).orElse(null);
    }

    @RequestMapping("/add0")
    public void add(@RequestBody @Valid Ticket t){

    }

    @RequestMapping(value = "/add", consumes = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody String jsonObj){
        try {

            JsonObject obj = (JsonObject) new JsonParser().parse(jsonObj);
            double x = obj.get("x").getAsDouble();
            double y = obj.get("y").getAsDouble();
            int typeId = obj.get("typeId").getAsInt();
            String description = obj.get("description").getAsString();
            byte[] picture = obj.get("picture").getAsString().getBytes();
            //TODO test

            Map<String, String> address = HereApi.getAddressFromPoint(x, y);
            if (address.containsKey("country") && address.containsKey("city")) {
                Map<String, String> data = new HashMap<>();
                data.put("country", address.get("country"));
                data.put("city", address.get("city"));
                String locationId = HereApi.getLocationId(data);
                Optional<City> tmp0 = cityService.findCityByLocationId(locationId);
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
                ticket.setStatus(ticketStatusService.getCreatedStatus());

                Optional<TicketType> type = ticketTypeRepository.findById(typeId);

                if (type.isPresent()) {
                    ticket.setType(type.get());
                    roadService.addTicket(roadOptional.get().getId(), ticketService.save(ticket));
                    roadService.updateSumAndCount(roadOptional.get().getId(), roadOptional.get().getSum() + type.get().getWeight(), roadOptional.get().getCount() + 1);
                    return "Success";
                } else
                    return "Wrong type id";
            }
            return "It is not city";
        } catch (IOException e) {
            return "Wrong coordinates";
        }
    }

    @RequestMapping(path = "/getBy/geo", method = RequestMethod.GET, consumes = "application/json")
    @ResponseBody
    public List<Ticket> getByGeo(@RequestParam double x0, @RequestParam double y0, @RequestParam double x1, @RequestParam double y1) {
        return ticketService.findAllByXBetweenAndYBetween(x0, y0, x1, y1);
    }

    @RequestMapping(path = "/type/add", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Integer addTicketType(@RequestBody String jsonObj) {
        System.out.println("Adding ticket type");

        JsonObject obj = (JsonObject) new JsonParser().parse(jsonObj);
        System.out.println(jsonObj);
        if (obj.has("name") && obj.has("weight")) {
            TicketType ticketType = new TicketType();
            System.out.println(obj.get("name"));
            ticketType.setName(obj.get("name").getAsString());
            ticketType.setWeight(obj.get("weight").getAsInt());
            return ticketTypeRepository.save(ticketType).getId();
        } else return -1;
    }

    @RequestMapping(path = "/type/getAll", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<TicketType> getAllTicketTypes(){
        return  ticketTypeRepository.findAll();
    }

    @RequestMapping(path = "/type/get", method = RequestMethod.GET)
    @ResponseBody
    public TicketType getType(@RequestParam Integer id){
        return ticketTypeRepository.findById(id).orElse(null);
    }

    @RequestMapping("/type/deleteAll")
    @ResponseBody
    public boolean deleteAllTypes(){
        try {
            ticketTypeRepository.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping(path = "/status/getAll", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<TicketStatus> getAllStatus(){
        return ticketStatusService.getAll();
    }
}
