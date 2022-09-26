package com.studentApp.studentinfo;



import com.studentApp.model.StudentPojo;
import com.studentApp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentPutTest extends TestBase {

    @Test
    public void put(){
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setEmail("xyz0112@gmail.com");
        studentPojo.setProgramme("Automation testing");

        Response response=given()
               .header("Content-Type","application/json")
                .pathParam("id","102")
                .body(studentPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }


}
