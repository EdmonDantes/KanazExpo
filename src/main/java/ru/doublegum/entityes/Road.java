package ru.doublegum.entityes;

import lombok.Data;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Road {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Point start;

    private Point end;

    @ManyToMany
    private Set<RoadProblem> problems;
}
