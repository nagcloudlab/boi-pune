package com.example.api;

import static io.restassured.RestAssured.*;

public class InfoApiTest {

    // api: http://localhost:8080/info
    // response:
    // {
    // "serviceName": "Transfer Service",
    // "version": "1.0.0",
    // "ip": "",
    // "port": 8080
    // }

    // using REST Assured to test the /info endpoint

    // @org.junit.jupiter.api.Test
    public void testGetInfo() {
        given()
                .baseUri("http://localhost:8080")
                .basePath("/info")
                .header("Content-Type", "application/json")
                .log().all()
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200);
    }

}
