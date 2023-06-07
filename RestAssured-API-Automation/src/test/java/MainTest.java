import api.endpoints.AuthenticationEndPoints;
import api.endpoints.ToolsEndPoints;
import api.pojos.ClientAuthentication;
import api.pojos.Tool;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import jdk.jfr.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;
import org.testng.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static org.testng.Reporter.log;

public class MainTest {

    Faker fakeCustData=new Faker();

    //EndPoints
    AuthenticationEndPoints authenticationEndPoints =new AuthenticationEndPoints();
    ToolsEndPoints toolsEndPoints=new ToolsEndPoints();

    //Modulues
    ClientAuthentication clientAuthentication =new ClientAuthentication();
    Tool tool =new Tool();

    //Runs Before all test
    @BeforeTest
    public void accessTokenSetUp(){
        String clientName=fakeCustData.name().firstName();
        clientAuthentication.setClientName(clientName);
        clientAuthentication.setClientEmail(clientName+"@test.com");
    }

    //Returns test description and test name
    @BeforeMethod
    public void displayTestInformation(Method testDescr){
        System.out.println(testDescr.getAnnotation(Test.class).description());
        System.out.println(testDescr.getAnnotation(Test.class).testName());
        //set client values

    }



    //Post to register Client
    @Test(description = "Register API Client and get access token",testName = "Get access token")
    public void registerAPIClient(){
        Response clientResponse= authenticationEndPoints.registerClient(this.clientAuthentication);
        String accessToken=clientResponse.then().log().all().extract().path("accessToken");
        clientAuthentication.setAccessToken(accessToken);
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
    @Test(description = "Get All Tools Test",testName = "Get all All Tools")
    public void getAllTools(){
        Response getAlltools= toolsEndPoints.getAllTools();
        Assert.assertEquals(getAlltools.getStatusCode(),200);
    }

    @Test
    public void getToolById(){
        tool.setToolId(4643);
        Response getToolById=toolsEndPoints.getSingleTool(tool);
        System.out.println(getToolById.then().log().all());
    }
}
