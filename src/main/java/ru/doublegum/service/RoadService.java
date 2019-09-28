package ru.doublegum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.doublegum.entities.City;
import ru.doublegum.entities.Road;
import ru.doublegum.entities.Ticket;
import ru.doublegum.repositories.RoadRepository;

import java.util.Optional;

@Service
public class RoadService {

    @Autowired
    private RoadRepository repository;

    @Autowired
    private TicketService ticketService;

    public Road firstInsert(Road road) {
        if (road != null && (road.getId() == null || road.getId() < 1))
            return repository.save(road);
        return road;
    }

    public Road save(Road road) {
        return repository.save(road);
    }

    public boolean addTicket(int idRoad, Ticket ticket) {
        ticket = ticketService.firstInsert(ticket);

        if (ticket != null) {
            Optional<Road> road = repository.findById(idRoad);
            if (road.isPresent()) {
                Road tmp = road.get();
                tmp.getTickets().add(ticket);
                repository.save(tmp);
                return true;
            }
        }
        return false;
    }

    public Optional<Road> findByCityAndName(City city, String name) {
        return repository.findByCityAndName(city, name);
    }

    public Optional<Road> findById(int id) {return repository.findById(id); }

    public boolean updateSumAndCount(int id, int sum, int count) {
        Optional<Road> tmp = repository.findById(id);
        if (tmp.isPresent()) {
            Road road = tmp.get();
            road.setSum(sum);
            road.setCount(count);
            repository.save(road);
            return true;
        }
        return false;
    }

}
