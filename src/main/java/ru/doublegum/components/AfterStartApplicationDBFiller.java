package ru.doublegum.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.doublegum.entities.TicketStatus;
import ru.doublegum.repositories.TicketStatusRepository;

@Component
public class AfterStartApplicationDBFiller {

    @Autowired
    private TicketStatusRepository ticketStatusRepository;

    @EventListener
    public void fillDataBase(ApplicationReadyEvent ignore) {
        TicketStatus ticketStatus = new TicketStatus();
        ticketStatus.setName("Created");

        ticketStatusRepository.save(ticketStatus);
    }
}
