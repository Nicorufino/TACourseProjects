package com.solvd.newsPortal.classes.article;

import com.solvd.newsPortal.classes.user.Suscription_level;
import com.solvd.newsPortal.classes.user.User;
import com.solvd.newsPortal.jaxbAdapters.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.sql.Date;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "article")
public class Article {
    @XmlAttribute(name = "id")
    private Long id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "date", required = true)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private LocalDate date;
    @XmlElement(name = "body")
    private String body;
    @XmlElement(name = "suscriptionLevel")
    private Suscription_level suscription_level;
    @XmlElement(name = "category")
    private Category category;
    @XmlElement(name = "author")
    private User author;

    public Article() {
    }

    public Article(Long id) {
        this.id = id;
    }

    public Article(String name, LocalDate date, String body, Suscription_level suscription_level, Category category, User author) {
        this.name = name;
        this.date = date;
        this.body = body;
        this.suscription_level = suscription_level;
        this.category = category;
        this.author = author;
    }

    public Article(Long id, String name, LocalDate date, String body, Suscription_level suscription_level, Category category, User author) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.body = body;
        this.suscription_level = suscription_level;
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

    public Suscription_level getSuscription_level() {
        return suscription_level;
    }

    public void setSuscription_level(Suscription_level suscription_level) {
        this.suscription_level = suscription_level;
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
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", body='" + body + '\'' +
                ", suscription_level=" + suscription_level +
                ", category=" + category +
                ", author=" + author +
                '}';
    }
}
