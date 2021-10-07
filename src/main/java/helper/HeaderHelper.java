package helper;

import enums.RequestInfo;
import exceptions.RequestNotDefined;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;

import java.util.Map;

import static io.restassured.config.MultiPartConfig.multiPartConfig;

public class HeaderHelper extends ApiHelper {

    private final Logger log = LogManager.getLogger(HeaderHelper.class);

    /**
     * defineNewRequest() it add bulk header to request
     *
     * @param headers it's headers as map object
     */
    protected void addHeaders(Map<String, Object> headers) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.headers(headers);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{} headers added", headers);
    }

    /**
     * defineNewRequest() it add to the request a header.
     *
     * @param key   it is the header key.
     * @param value it is the header value
     */
    protected void addHeader(String key, String value) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.header(key, value);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{}, {} header added", key, value);
    }


    /**
     * it is add to the request SOAPAction as header.
     *
     * @param soapAction it is the SOAPAction
     * @throws RequestNotDefined if request is null, the exception will throw
     */
    protected void addSOAPAction(String soapAction) throws RequestNotDefined {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.header("SOAPAction", soapAction);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
    }

    /**
     * it is add to the request bearer token as header
     *
     * @param accessToken it is the token.
     */
    protected void addBearerTokenToHeader(String accessToken) {
        addHeader("Authorization", "Bearer " + accessToken);
    }

    protected void addMultiPartContentType(String defaultBoundary) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.contentType("multipart/form-data")
                .config(RestAssuredConfig
                        .config()
                        .multiPartConfig(multiPartConfig()
                        .defaultFileName(null).defaultBoundary(defaultBoundary)))
                .contentType("multipart/form-data;");
    }
}
