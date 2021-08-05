package com.solvd.newsPortal.classes.user;

public class User {
    private Long id;
    private String name;
    private String last_name;
    private Integer age;
    private Suscription_level suscription_level;

    public User() {
    }

    public User(Long id) {
        this.id = id;
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
