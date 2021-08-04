package com.solvd.newsPortal;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Article {
    private Long id;
    private String name;
    private Date date;
    private String body;
    private Long Suscription_level_id;
    private Long Categories_id;
    private Long author;

    public Article() {
    }

    public Article(String name, Date date, String body, Long suscription_level_id, Long categories_id, Long author) {
        this.name = name;
        this.date = date;
        this.body = body;
        Suscription_level_id = suscription_level_id;
        Categories_id = categories_id;
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

    public Long getSuscription_level_id() {
        return Suscription_level_id;
    }

    public void setSuscription_level_id(Long suscription_level_id) {
        Suscription_level_id = suscription_level_id;
    }

    public Long getCategories_id() {
        return Categories_id;
    }

    public void setCategories_id(Long categories_id) {
        Categories_id = categories_id;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }
}
