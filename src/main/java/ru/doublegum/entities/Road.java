package ru.doublegum.entities;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Road implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer sum = 0;

    @Column(nullable = false)
    private Integer count = 0;

    @OneToMany
    private Set<Ticket> tickets = new HashSet<>();

    @ManyToOne(targetEntity = City.class)
    @JoinColumn(name = "city")
    private City city;
}
