package ru.doublegum.entityes;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class RoadProblem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private Double x;

    @Column(nullable = false)
    private Double y;

    @Column(nullable = false)
    private RoadProblemType type = RoadProblemType.ROUGHNESS;

    @Column(nullable = false)
    private Integer weight = 0;

}
