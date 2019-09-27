package ru.doublegum.entityes;

import lombok.Data;
import org.springframework.data.geo.Point;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class RoadProblem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Point geoPoint;

    private Integer weight;

}
