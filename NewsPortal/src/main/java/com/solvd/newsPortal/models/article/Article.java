package com.solvd.newsPortal.models.article;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.solvd.newsPortal.models.user.Suscription_level;
import com.solvd.newsPortal.models.user.User;
import com.solvd.newsPortal.jackson.LocalDateDeserializer;
import com.solvd.newsPortal.jackson.LocalDateSerializer;
import com.solvd.newsPortal.jaxbAdapters.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.sql.Date;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "article")
@JsonTypeName("article")
public class Article {
    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "date")
    @JsonProperty("date")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;
    @JsonProperty("body")
    @XmlElement(name = "body")
    private String body;
    @JsonProperty("suscriptionLevel")
    @XmlElement(name = "suscriptionLevel")
    private Suscription_level suscription_levelRequired;
    @JsonProperty("category")
    @XmlElement(name = "category")
    private Category category;
    @JsonProperty("author")
    @XmlElement(name = "author")
    private User author;

    public Article() {
    }

    public Article(Long id) {
        this.id = id;
    }

    public Article(String name, LocalDate date, String body, Suscription_level suscription_levelRequired, Category category, User author) {
        this.name = name;
        this.date = date;
        this.body = body;
        this.suscription_levelRequired = suscription_levelRequired;
        this.category = category;
        this.author = author;
    }

    public Article(Long id, String name, LocalDate date, String body, Suscription_level suscription_levelRequired, Category category, User author) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.body = body;
        this.suscription_levelRequired = suscription_levelRequired;
        this.category = category;
        this.author = author;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date.toLocalDate();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Suscription_level getSuscription_levelRequired() {
        return suscription_levelRequired;
    }

    public void setSuscription_levelRequired(Suscription_level suscription_levelRequired) {
        this.suscription_levelRequired = suscription_levelRequired;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return  "{id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", body='" + body + '\'' +
                ", suscription_levelRequired=" + suscription_levelRequired +
                ", category=" + category +
                ", author=" + author +
                '}';
    }
}
