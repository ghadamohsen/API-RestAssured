package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://api.restful-api.dev";
    }

    @AfterClass
    public void tearDown() {
        
    }
}
