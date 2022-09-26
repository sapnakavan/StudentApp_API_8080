package com.studentApp.studentinfo;


import com.studentApp.model.StudentPojo;
import com.studentApp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class StudentCRUDTest extends TestBase {


    @Test// get full list
    public void test001() {
        Response response=given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }



    @Test// post new data and retrive id
    public void test002() {
        List<String>courses=new ArrayList<>();
        courses.add("java");
        courses.add("selenium");
        courses.add("restassured");

        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName("sap");
        studentPojo.setLastName("patel");
        studentPojo.setEmail("abc154@gmail.com");
        studentPojo.setProgramme("api testing");
        studentPojo.setCourses(courses);

        Response response=given()
                .header("Content-Type","application/json")
                .body(studentPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();


    }



    @Test// update data with id
    public void test003() {
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName("Test11");
        studentPojo.setEmail("xyz121@gmail.com");

        Response response=given()
                .header("Content-Type","application/json")
                .pathParam("id","101")
                .body(studentPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }



    @Test // delete above id
    public void test004() {
        Response response=given()
                .pathParam("id","4")
                .when()
                .delete("/{id}");
        response.then().statusCode(204);
        response.prettyPrint();
    }

    @Test // retrieve id and validate id has delete
    public void test005() {
        Response response=given()
                .pathParam("id","4")
                .when()
                .get("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();
    }

    }



