package ru.doublegum.entityes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class GeoPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private double x;

    @Column(nullable = false)
    private double y;
}
