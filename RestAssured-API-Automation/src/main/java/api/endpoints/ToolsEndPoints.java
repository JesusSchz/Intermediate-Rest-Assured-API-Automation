package api.endpoints;

import api.pojos.Tool;
import io.restassured.RestAssured;
import io.restassured.response.Response;

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
    public Response getSingleTool(Tool tool) {
        Response getSingleToolResponse = null;
        if (tool.getToolId() != 0) {
            getSingleToolResponse = RestAssured
                .given()
                    .pathParam(":toolId",tool.getToolId())
                    .log().all()
                .when()
                    .get(Routes.getSingleTool);

            System.out.println(getSingleToolResponse.then().log().all());
        }
        return getSingleToolResponse;
    }
}
