package com.solvd.newsPortal.models.article;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class Category {
    @JsonProperty("id")
    @XmlAttribute(name = "id")
    private Long id;
    @JsonProperty("name")
    @XmlElement(name = "name")
    private String name;

    public Category() {
    }

    public Category(Long id) {
        this.id = id;
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
