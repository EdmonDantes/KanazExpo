package ru.doublegum.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.io.Serializable;

@Entity
@Data
public class Ticket implements Serializable {

    @Null
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private Double x;
    @Column(nullable = false)
    private Double y;

    @Column
    private String email; //TODO

    @Column
    private String description; //TODO annotation

    @Lob // Storing big data
    private String picture;

    @ManyToOne
    private TicketType type;

    @ManyToOne
    private TicketStatus status;
}
