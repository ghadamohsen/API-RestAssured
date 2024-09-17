package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    public static Response addNewDevice(String name, int year, double price, String cpuModel, String hardDiskSize) {
        String payload = String.format(
            "{ \"name\": \"%s\", \"data\": { \"year\": %d, \"price\": %.2f, \"CPU model\": \"%s\", \"Hard disk size\": \"%s\" } }",
            name, year, price, cpuModel, hardDiskSize
        );

        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/objects")
                .then()
                .extract()
                .response();
    }
}
