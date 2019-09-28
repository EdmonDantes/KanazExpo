package ru.doublegum.entityes;

import java.io.Serializable;

public enum RoadProblemType implements Serializable {
    ROUGHNESS, // Ямы, шероховатости
    MANHOLE, // Люк
    ROUGHROAD, // Длинная неровная дорога
    ROADMARK, // Дорожная разметка
    TRAFFICLIGHT // светофор
}