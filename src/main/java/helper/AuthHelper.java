package helper;


import enums.RequestInfo;
import io.restassured.authentication.OAuthSignature;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;


public class AuthHelper extends ApiHelper {

    private final Logger log = LogManager.getLogger(AuthHelper.class);


    public void basicAuth(String user, String password)  {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.auth().basic(user, password);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("Basic auth to request as user: {}, password{}", user, password);
    }

    public void preBasicAuth(String user, String password)  {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.auth().preemptive().basic(user, password);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
    }

    public void oauth2(String var1)  {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.auth().oauth2(var1);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
    }

    public void oauth2(String var1, OAuthSignature var2)  {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.auth().oauth2(var1, var2);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
    }

    public void oauth(String var1, String var2, String var3, String var4)  {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.auth().oauth(var1, var2, var3, var4);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);

    }

    public void addBearerToken(String token){
        HeaderHelper headerHelper = new HeaderHelper();
        headerHelper.addBearerTokenToHeader(token);
    }


}
