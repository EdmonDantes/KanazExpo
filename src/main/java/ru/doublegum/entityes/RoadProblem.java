package ru.doublegum.entityes;

import lombok.Data;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class RoadProblem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private Set<Point> geoPoints = new HashSet<>();

    @Column(nullable = false)
    private RoadProblemType type = RoadProblemType.ROUGHNESS;

    @Column(nullable = false)
    private Integer weight = 0;

}
