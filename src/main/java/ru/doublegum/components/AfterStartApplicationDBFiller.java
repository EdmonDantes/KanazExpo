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
        TicketStatus createStatus = new TicketStatus();
        createStatus.setName("Создан");

        TicketStatus checkStatus = new TicketStatus();
        checkStatus.setName("Рассмотрена");

        TicketStatus beginStatus = new TicketStatus();
        beginStatus.setName("Начало работ");

        TicketStatus finishStatus = new TicketStatus();
        finishStatus.setName("Окончание работ");

        TicketStatus closedStatus = new TicketStatus();
        closedStatus.setName("Закрыта");

        ticketStatusRepository.save(createStatus);
        ticketStatusRepository.save(checkStatus);
        ticketStatusRepository.save(beginStatus);
        ticketStatusRepository.save(finishStatus);
        ticketStatusRepository.save(closedStatus);
    }
}
