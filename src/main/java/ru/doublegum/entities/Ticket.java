package ru.doublegum.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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

    private String description;

    @Lob
    private byte[] picture;

    @ManyToOne
    private TicketType type;

    @ManyToOne
    private TicketStatus status;

    // TODO: equals UTC-0
    @Column
    private long datetimeTicketCreated = System.currentTimeMillis();

    @Column
    private long datetimeTicketChecked;

    @Column
    private long datetimeTicketStarted;

    @Column
    private long datetimeTicketEnded;

    @Column
    private long datetimeTicketClosed;
}
