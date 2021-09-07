package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import javax.lang.model.type.ArrayType;
import java.io.File;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import static io.restassured.RestAssured.given;
import io.restassured.module.jsv.JsonSchemaValidator;

public class APITestRestAssured extends AbstractTest {
    private final static Logger LOGGER = Logger.getLogger(APITestRestAssured.class);
    private Integer id;

    @Test(groups = "creation")
    public void postFavourite(){
        RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder()
                        .withinRange('0', 'z')
                        .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                        .build();

        String imageId = randomStringGenerator.generate(9);


        given().log().all().body("{\n  \"image_id\": \"" + imageId +"\",\n" +
                        "  \"sub_id\": \"your-user-1234\"\n}").
                header("x-api-key", "2c713889-b86e-4a39-8e1e-315b7e791f67").
                header("Content-Type", "application/json").
                post("https://api.thecatapi.com/v1/favourites").then().assertThat().statusCode(200).
                assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/api/users/_post/favouriteRs.schema")));
    }

    @Test(groups = "get", dependsOnGroups = "creation")
    public void getFavourite(){
        ArrayList<Integer> ids = given().log().all().
                header("x-api-key", "2c713889-b86e-4a39-8e1e-315b7e791f67").
                param("limit", 1).get("https://api.thecatapi.com/v1/favourites").
                then().assertThat().statusCode(200).assertThat().
                body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/api/users/_get/favouritesRs.schema"))).
                extract().path("id");
        id = ids.get(0);
    }

    @Test(dependsOnGroups = "get")
    public void deleteFavourite(){
        given().log().all().
                header("x-api-key", "2c713889-b86e-4a39-8e1e-315b7e791f67").
                pathParam("favourite_id",id).
                delete("https://api.thecatapi.com/v1/favourites/{favourite_id}").then().
                assertThat().statusCode(200).assertThat().body("message", equalTo("SUCCESS"));
    }


}
