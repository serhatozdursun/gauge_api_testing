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
     * @throws RequestNotDefined if request is null, the exception will throw
     */
    public void addHeaders(Map<String, Object> headers) throws RequestNotDefined {
        checkIfRequestDefined();
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
     * @throws RequestNotDefined if request is null, the exception will throw
     */
    public void addHeader(String key, String value) throws RequestNotDefined {
        checkIfRequestDefined();
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
    public void addSOAPAction(String soapAction) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.header("SOAPAction", soapAction);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
    }

    /**
     * it is add to the request bearer token as header
     *
     * @param accessToken it is the token.
     * @throws RequestNotDefined if request is null, the exception will throw
     */
    public void addBearerTokenToHeader(String accessToken) throws RequestNotDefined {
        addHeader("Authorization", "Bearer " + accessToken);
    }

    public void addMultiPartContentType(String defaultBoundary) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.contentType("multipart/form-data")
                .config(RestAssuredConfig
                        .config()
                        .multiPartConfig(multiPartConfig()
                        .defaultFileName(null).defaultBoundary(defaultBoundary)))
                .contentType("multipart/form-data;");
    }
}
