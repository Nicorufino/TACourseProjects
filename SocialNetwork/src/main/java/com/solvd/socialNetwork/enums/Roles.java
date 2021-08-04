package com.solvd.socialNetwork.enums;

public enum Roles {
    OTHER(1, "other", "other_role"),
    USER(2, "user", "user_role"),
    MODERATOR(3, "moderator", "moderator_role"),
    ADMIN(4, "admin", "admin_role");

    private long id;
    private String name;
    private String apiName;

    Roles(long id, String name, String apiName) {
        this.id = id;
        this.name = name;
        this.apiName = apiName;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getApiName() {
        return apiName;
    }
}
