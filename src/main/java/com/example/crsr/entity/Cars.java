package com.example.crsr.entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

@Entity(name = "cars")
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "object_id")
    private String objectId;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "release_date")
    private String date;

    @Column(name = "cost")
    private String cost;

    public Cars(Integer id, String objectId, String name, String color, String date, String cost) {
        this.id = id;
        this.objectId = objectId;
        this.name = name;
        this.color = color;
        this.date = date;
        this.cost = cost;
    }

    public Cars() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        if (!Pattern.compile("^ ").matcher(color).matches()) {
            setColor(color.trim().replaceAll("[ ]", "_"));
        }

        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        if (date == null || date.equals("")) {
            setDate(Date.from(Instant.now()).toString());
        }

        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getObjectId() {
        if (objectId == null) {
            setObjectId(UUID.randomUUID().toString());
        }

        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCost() {
        return cost;
    }
}

