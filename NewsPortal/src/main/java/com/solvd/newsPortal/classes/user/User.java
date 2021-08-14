package com.solvd.newsPortal.classes.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "author")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    @JsonProperty("id")
    @XmlAttribute(name = "id")
    private Long id;
    @JsonProperty("firstname")
    @XmlElement(name = "firstname")
    private String name;
    @JsonProperty("lastname")
    @XmlElement(name = "lastname")
    private String last_name;
    @JsonProperty("age")
    @XmlAttribute(name = "age")
    private Integer age;
    @JsonProperty("suscriptionLevel")
    @XmlElement(name = "suscriptionLevel")
    private Suscription_level suscription_level;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String name, String last_name, Integer age, Suscription_level suscription_level) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.suscription_level = suscription_level;
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

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Suscription_level getSuscription_level() {
        return suscription_level;
    }

    public void setSuscription_level(Suscription_level suscription_level) {
        this.suscription_level = suscription_level;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", suscription_level=" + suscription_level +
                '}';
    }
}
