package ru.doublegum.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private Double x;
    @Column(nullable = false)
    private Double y;

    @Column(nullable = false)
    private Integer weight = 0;

    @ManyToOne
    private TicketProblemType type;

    @ManyToOne
    private TicketStatus status;

    // TODO: equals UTC-0
    @Column
    private long datetimeTicketCreated;

    @Column
    private long datetimeTicketChecked;

    @Column
    private long datetimeTicketStarted;

    @Column
    private long datetimeTicketEnded;

    @Column
    private long datetimeTicketClosed;
}