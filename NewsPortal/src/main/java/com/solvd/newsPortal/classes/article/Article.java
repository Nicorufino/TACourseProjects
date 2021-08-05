package com.solvd.newsPortal.classes.article;

import com.solvd.newsPortal.classes.user.Suscription_level;
import com.solvd.newsPortal.classes.user.User;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Article {
    private Long id;
    private String name;
    private Date date;
    private String body;
    private Suscription_level suscription_level;
    private Category category;
    private User author;

    public Article() {
    }

    public Article(Long id) {
        this.id = id;
    }

    public Article(String name, Date date, String body, Suscription_level suscription_level, Category category, User author) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
