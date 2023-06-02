import api.endpoints.AuthenticationEndPoints;
import api.endpoints.ToolsEndPoints;
import api.pojos.ClientAuthentication;
import api.pojos.Tool;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Reporter.log;

public class MainTest {

    Faker fakeCustData=new Faker();

    //EndPoints
    AuthenticationEndPoints authenticationEndPoints =new AuthenticationEndPoints();
    ToolsEndPoints toolsEndPoints=new ToolsEndPoints();

    //Modulues
    ClientAuthentication clientAuthentication =new ClientAuthentication();
    Tool tool =new Tool();

    @BeforeTest
    public void accessTokenSetUp(){
        //set client values
        String clientName=fakeCustData.name().firstName();
        clientAuthentication.setClientName(clientName);
        clientAuthentication.setClientEmail(clientName+"@test.com");
    }

    //Post to register Client
    @Test
    public void registerAPIClient(){
        Response clientResponse= authenticationEndPoints.registerClient(this.clientAuthentication);
        String accessToken=clientResponse.then().log().all().extract().path("accessToken");
        clientAuthentication.setAccessToken(accessToken);
        log("Created biennnn afuera del if");
        if(accessToken!=null){
            Assert.assertEquals(clientResponse.getStatusCode(),201);
            Assert.assertNotNull(clientResponse.getContentType());
        }else{
            Assert.assertEquals(clientResponse.getStatusCode(),409);
            Assert.assertNotNull(clientResponse.getContentType());
            Assert.assertNotNull(clientAuthentication.getError());
        }
    }

    //GetAllTools request
    @Test
    public void getAllTools(){
        Response getAlltools= toolsEndPoints.getAllTools();
        Assert.assertEquals(getAlltools.getStatusCode(),200);
        System.out.println("access token from getTools"+ clientAuthentication.getAccessToken());
    }
}
