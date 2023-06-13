package api.endpoints;

public class Routes {

    /**
     * This class contains endpoint URLs
     **/
    //BaseUrl
    public static String baseUrl = "https://simple-tool-rental-api.glitch.me";

    //Get Status
    public static String getStatus = baseUrl + "/status";

    //Get all tools
    public static String getAllTools = baseUrl + "/tools";

    //Get a single tool by Id
    public static String getSingleToolById = baseUrl + "/tools/{:toolId}";

    //Get a single tool by Category
    public static String getSingleToolByCategory = baseUrl + "/tools/";

    //Get orders
    public static String getOrders = baseUrl + "/orders";

    //Get single order
    public static String getSingleOrder = baseUrl + "/orders/{:orderId}";

    //Create a new order
    public static String createNewOrder = baseUrl + "/orders";

    //Update an order
    public static String updateOrder = baseUrl + "/orders/:orderId";

    //Delete an order
    public static String deleteOrder = baseUrl + "/orders/:orderId";

    //Register a new API client(Get access token)
    public static String clientRegister = baseUrl + "/api-clients";

}
