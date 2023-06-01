package api.endpoints;

import api.pojos.ClientAuthentication;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.http.ContentType.JSON;

public class Authentication {
    ClientAuthentication client = new ClientAuthentication();

    //Create client and get accessToken
    public Response registerClient(){
        client.setClientEmail("some@email.com");
        client.setClientName("Some Name");
        Response tokenClient = RestAssured
            .given()
                .contentType(JSON)
                .body(client)
            .when()
                .post(Routes.clientRegister);

        System.out.println(tokenClient.then().log().all());
        return tokenClient;

    }
}
