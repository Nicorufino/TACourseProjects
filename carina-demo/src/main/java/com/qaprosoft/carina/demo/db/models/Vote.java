package com.qaprosoft.carina.demo.db.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vote {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("image_id")
    private String imageId;
    @JsonProperty("sub_id")
    private String subId;
    @JsonProperty("value")
    private int value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*country_code": "AR",
            "created_at": "2021-09-06T20:11:53.000Z",
            "id": 323791,
            "image_id": "asf2",
            "sub_id": "my-user-1234",
            "value": 1

     */
}
