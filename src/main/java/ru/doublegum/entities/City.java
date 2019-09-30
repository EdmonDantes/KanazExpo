package ru.doublegum.entities;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
    public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String locationId;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "city", targetEntity = Road.class)
    private Set<Road> roads = new HashSet<>();
}
