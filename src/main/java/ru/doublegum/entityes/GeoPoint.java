package ru.doublegum.entityes;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class GeoPoint implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private double x_ltt;

    @Column(nullable = false)
    private double y_lng;

    public JsonObject toJson() {
        JsonObject object = new JsonObject();
        object.add("ltt", new JsonPrimitive(x_ltt));
        object.add("lng", new JsonPrimitive(y_lng));
        return object;
    }
}
