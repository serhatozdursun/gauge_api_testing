package helper;

import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;

import java.util.Map;

import static enums.RequestInfo.REQUEST;

public class PathParameterHelper extends ApiHelper {

    private final Logger log = LogManager.getLogger(PathParameterHelper.class);
    private static final String LOG_INFO = "{} = {} added to request as path param";

    /**
     * Add path param to request
     *
     * @param key   is param key as string.
     * @param value is param value as string.
     */
    protected void addPathParam(String key, String value) {
        defineNewRequestIfNull();
        var request = (RequestSpecification) StoreApiInfo.get(REQUEST.info);
        request.pathParam(key, value);
        StoreApiInfo.put(REQUEST.info, request);
        log.info(LOG_INFO, key, value);
    }

    /**
     * Add bulk path param to request
     *
     * @param qParam bulk params as map object
     */
    protected void addPathParams(Map<String, Object> qParam) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(REQUEST.info);
        request.pathParams(qParam);
        StoreApiInfo.put(REQUEST.info, request);
        log.info("{} bulk added to request as path params ", qParam);
    }

    /**
     * Add path param to request
     *
     * @param key   is param key as string.
     * @param value is param value as object.
     */
    protected void addPathParam(String key, Object value) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(REQUEST.info);
        request.pathParam(key, value);
        StoreApiInfo.put(REQUEST.info, request);
        var stringValue = String.valueOf(value);
        log.info(LOG_INFO, key, stringValue);
    }

    /**
     * Add bulk path param to request
     *
     * @param key   is param key as string.
     * @param value is param value as object.
     */
    protected void addPathParams(String key, Object value) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(REQUEST.info);
        request.pathParams(key, value);
        StoreApiInfo.put(REQUEST.info, request);
        var stringValue = String.valueOf(value);
        log.info(LOG_INFO, key, stringValue);
    }
}
