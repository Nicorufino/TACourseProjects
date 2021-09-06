package com.qaprosoft.carina.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.DeleteUserMethod;
import com.qaprosoft.carina.demo.api.GetUserMethods;
import com.qaprosoft.carina.demo.api.GetVoteMethod;
import com.qaprosoft.carina.demo.api.PostUserMethod;
import com.qaprosoft.carina.demo.db.models.Vote;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class APITest extends AbstractTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.Lookup.class);
    private Long id;

    @Test(groups = "info")
    public void getBreedData(){
        GetUserMethods getUserMethods = new GetUserMethods();
        getUserMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUserMethods.addParameter("q", "sib");
        getUserMethods.replaceUrlPlaceholder("page", "/search");
        getUserMethods.callAPI();
        getUserMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());

    }

    @Test(groups = "info")
    public void getBreeds(){
        GetUserMethods getUserMethods = new GetUserMethods();
        getUserMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUserMethods.replaceUrlPlaceholder("page", "");
        getUserMethods.addParameter("limit", "2");
        getUserMethods.setResponseTemplate("api/users/_get/rsbreeds.json");
        getUserMethods.callAPI();
        getUserMethods.validateResponse();


    }



    @Test(groups = "post", dependsOnGroups = "info")
    public void postVote(){
        PostUserMethod postUserMethod = new PostUserMethod();
        postUserMethod.callAPI();
        postUserMethod.validateResponse(JSONCompareMode.STRICT_ORDER);
    }

    @Test(groups = "getID", dependsOnGroups = "post")
    public void getMyRequest() throws JsonProcessingException {
        GetVoteMethod getVoteMethod = new GetVoteMethod();
        getVoteMethod.callAPI();
        getVoteMethod.validateResponse(JSONCompareMode.STRICT_ORDER);



        //parsing the id to be used in deleteVote test
        String rs = getVoteMethod.callAPI().asString();
        TypeReference<List<Vote>> typeRef = new TypeReference<List<Vote>>() { };
        ObjectMapper mapper = new ObjectMapper();
        List<Vote> votes = mapper.readValue(rs, typeRef);
        id = votes.stream().findFirst().get().getId();
    }

    @Test(dependsOnGroups = "getID")
    public void deleteVote(){
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod();
        deleteUserMethod.replaceUrlPlaceholder("vote_id", String.valueOf(id));
        deleteUserMethod.callAPI();
        deleteUserMethod.validateResponse();
    }


}
