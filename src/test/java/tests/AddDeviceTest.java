package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiUtils;
import base.BaseTest;

public class AddDeviceTest extends BaseTest {

    @Test(description = "Test to add a new device and validate the response")
    public void testAddNewDevice() {
        Response response = ApiUtils.addNewDevice("Apple Max Pro 1TB", 2023, 7999.99, "Apple ARM A7", "1 TB");

        // Validate the response status code
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");

        // Validate the response content
        String id = response.jsonPath().getString("id");
        String name = response.jsonPath().getString("name");
        String createdAt = response.jsonPath().getString("createdAt");
        int year = response.jsonPath().getInt("data.year");
        double price = response.jsonPath().getDouble("data.price");

        Assert.assertNotNull(id, "ID should not be null");
        Assert.assertNotNull(createdAt, "CreatedAt should not be null");
        Assert.assertEquals(name, "Apple Max Pro 1TB", "Name should match");
        Assert.assertEquals(year, 2023, "Year should match");
        Assert.assertEquals(price, 7999.99, "Price should match");

    }
}
