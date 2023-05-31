package api.endpoints;

import api.pojos.Tool;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.http.ContentType.JSON;

public class ToolsEndPoints {

    //Return all tools
    public Response getAllTools() {
        Response getAllToolsResponse = RestAssured
            .given()
                .log().all()
            .when()
                .get(Routes.getAllTools);
        //.then().log().all();
        System.out.println(getAllToolsResponse.then().log().all());
        return getAllToolsResponse;

    }

    //get single tool
    public Response getSingleTool() {
        Tool setToolValues = new Tool();
        setToolValues.setToolId(0);
        setToolValues.setUserManual(true);

        Response getSingleToolResponse = null;
        if (setToolValues.getToolId() != 0) {
            getSingleToolResponse = RestAssured
                .given()
                    .pathParam(":toolId",1709)
                    .log().all()
                .when()
                    .get(Routes.getSingleTool);

            System.out.println(getSingleToolResponse.then().log().all());
        }


        return getSingleToolResponse;
    }
}
