package api.endpoints;

import api.pojos.ClientAuthentication;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.http.ContentType.JSON;

public class AuthenticationEndPoints {
    ClientAuthentication client = new ClientAuthentication();

    //Create client and get accessToken
    public Response registerClient(ClientAuthentication clienteData){
        client.setClientEmail(clienteData.getClientEmail());
        client.setClientName(clienteData.getClientName());
        Response tokenClient = RestAssured
            .given()
                .contentType(JSON)
                .body(client)
            .when()
                .post(Routes.clientRegister);

        //System.out.println(tokenClient.then().log().all());
        return tokenClient;

    }
}
