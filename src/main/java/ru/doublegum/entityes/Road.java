package ru.doublegum.entityes;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
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

    private Double startX;
    private Double startY;
    private Double endX;
    private Double endY;

    @Column(nullable = false)
    private Integer sum = 0;

    @Column(nullable = false)
    private Integer count = 0;

    @OneToMany
    private Set<RoadProblem> problems = new HashSet<>();

    public GeoPoint getStart(){
        GeoPoint result = new GeoPoint();
        result.setX_ltt(startX);
        result.setY_lng(startY);
        return result;
    }

    public GeoPoint getEnd(){
        GeoPoint result = new GeoPoint();
        result.setX_ltt(endX);
        result.setY_lng(endY);
        return result;
    }

    public JsonObject toJson(){
        JsonObject object = new JsonObject();
        object.add("start", getStart().toJson());
        object.add("end", getEnd().toJson());
        object.add("density", new JsonPrimitive(sum / count));
        return object;
    }
}
