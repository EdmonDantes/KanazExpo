package ru.doublegum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.doublegum.HereApi;
import ru.doublegum.entities.Ticket;
import ru.doublegum.service.TicketService;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/add", consumes = "application/json", method = RequestMethod.POST)
    public String add(@RequestBody double x, @RequestBody double y, @RequestBody String type){
        try {
            Map<String, String> address = HereApi.getAddressFromPoint(x, y);

            //return ticketService.firstInsert()

        } catch (IOException e) {
            return "Wrong coordinates";
        }

        return "Server is wrong";
    }
}
