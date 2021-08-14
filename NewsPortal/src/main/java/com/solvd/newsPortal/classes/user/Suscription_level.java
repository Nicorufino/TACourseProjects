package com.solvd.newsPortal.classes.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "suscriptionLevel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Suscription_level {
    @JsonProperty("id")
    @XmlAttribute(name = "id")
    private Long id;
    @JsonProperty("name")
    @XmlElement(name = "name")
    private String name;
    @JsonProperty("cost")
    @XmlElement(name = "cost")
    private Float cost;

    public Suscription_level() {
    }

    public Suscription_level(Long id) {
        this.id = id;
    }

    public Suscription_level(Long id, String name, Float cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Suscription_level{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
