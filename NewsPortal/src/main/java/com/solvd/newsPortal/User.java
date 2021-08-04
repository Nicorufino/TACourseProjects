package com.solvd.newsPortal;

public class User {
    private Long id;
    private String name;
    private String last_name;
    private Integer age;
    private Long Suscription_level_id;

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

    public Long getSuscription_level_id() {
        return Suscription_level_id;
    }

    public void setSuscription_level_id(Long suscription_level_id) {
        Suscription_level_id = suscription_level_id;
    }
}
