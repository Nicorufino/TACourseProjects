import org.apache.log4j.Logger;
import static io.restassured.RestAssured.given;

public class RestAssuredRequest {
    private final static Logger LOGGER = Logger.getLogger(RestAssuredRequest.class);
    public  void getResponseData(){
       given().when().get("https://static-exp1.licdn.com/sc/h/1c5u578iilxfi4m4dvc4q810q")
               .then().assertThat().contentType("image/svg+xml").log().body();
    }
}
