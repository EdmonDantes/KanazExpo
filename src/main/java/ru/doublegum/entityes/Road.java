package ru.doublegum.entityes;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Road {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private GeoPoint start;
    @OneToOne
    private GeoPoint end;

    @OneToMany
    private Set<RoadProblem> problems = new HashSet<>();
}
