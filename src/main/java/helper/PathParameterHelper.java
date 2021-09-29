package helper;

import enums.RequestInfo;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;

import java.util.Map;

public class PathParameterHelper extends ApiHelper {

    private final Logger log = LogManager.getLogger(PathParameterHelper.class);
    private static final String LOG_INFO = "{} = {} added to request as path param";

    /**
     * Add path param to request
     *
     * @param key   is param key as string.
     * @param value is param value as string.
     */
    public void addPathParam(String key, String value) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.pathParam(key, value);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info(LOG_INFO, key, value);
    }

    /**
     * Add bulk path param to request
     *
     * @param qParam bulk params as map object
     */
    public void addPathParams(Map<String, Object> qParam) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.pathParams(qParam);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{} bulk added to request as path params ", qParam);
    }

    /**
     * Add path param to request
     *
     * @param key   is param key as string.
     * @param value is param value as object.
     */
    public void addPathParam(String key, Object value) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.pathParam(key, value);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        var stringValue = String.valueOf(value);
        log.info(LOG_INFO, key, stringValue);
    }

    /**
     * Add bulk path param to request
     *
     * @param key   is param key as string.
     * @param value is param value as object.
     */
    public void addPathParams(String key, Object value) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.pathParams(key, value);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        var stringValue = String.valueOf(value);
        log.info(LOG_INFO, key, stringValue);
    }
}
