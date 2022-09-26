package com.studentApp.studentinfo;


import com.studentApp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentsInfo() {
        Response response=given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleStudentInfo() {
    Response response=given()
            .pathParam("id","3")
            .when()
            .get("/{id}");
    response.then().statusCode(404);
    response.prettyPrint();
    }

    @Test
    public void searchStudentWithParameter() {
        HashMap<String,Object>qParm= new HashMap<>();
        qParm.put("programme","Computer Science");
        qParm.put("limit",3);

        Response response=given()
                //.queryParam("programme","Computer Science")
               // .queryParam("limit",3)
                .queryParams(qParm)
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }




}
