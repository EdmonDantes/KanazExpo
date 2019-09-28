package ru.doublegum.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
public class TicketStatus implements Serializable {

    @Column
    private String name;
}
