package com.solvd.newsPortal.models.user;

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
    private String lastName;
    @JsonProperty("age")
    @XmlAttribute(name = "age")
    private Integer age;
    @JsonProperty("suscriptionLevel")
    @XmlElement(name = "suscriptionLevel")
    private SuscriptionLevel suscriptionLevel;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String name, String lastName, Integer age, SuscriptionLevel suscriptionLevel) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.suscriptionLevel = suscriptionLevel;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SuscriptionLevel getSuscriptionLevel() {
        return suscriptionLevel;
    }

    public void setSuscriptionLevel(SuscriptionLevel suscriptionLevel) {
        this.suscriptionLevel = suscriptionLevel;
    }

    @Override
    public String toString() {
        return  "{id=" + id +
                ", name='" + name + '\'' +
                ", last_name='" + lastName + '\'' +
                ", age=" + age +
                ", suscription_level=" + suscriptionLevel +
                '}';
    }
}
