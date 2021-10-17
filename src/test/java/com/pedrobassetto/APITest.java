package com.pedrobassetto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.get;

import io.restassured.RestAssured;

public class APITest {

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://showcase.api.linx.twenty57.net";
    }

    @Test
    public void testConvertTimestampToUTCSuccess(){
        get("/UnixTime/fromunixtimestamp?unixtimestamp=1634436707").then().statusCode(200);
        String date = get("/UnixTime/fromunixtimestamp?unixtimestamp=1634436707").then().assertThat().statusCode(200).extract().path("Datetime");
        assertEquals("2021-10-17 02:11:47", date);

    }

    @Test
    public void testConvertTimestampToUTCFailure(){
        get("/UnixTime/fromunixtimestamp?unixtimestamp=Pedro").then().statusCode(409);
    }
    
}
