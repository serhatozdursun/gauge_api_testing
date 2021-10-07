package helper;

import enums.RequestInfo;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;

import java.util.Map;

public class FormParamsHelper extends ApiHelper {

    private final Logger log = LogManager.getLogger(FormParamsHelper.class);
    public static final String LOG_INFO = "{} = {} added to request as form param";

    /**
     * Add form param to request
     *
     * @param key   is param key as string.
     * @param value is param value as string.
     */
    protected void addFormParam(String key, String value) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.formParam(key, value);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info(LOG_INFO, key, value);
    }

    /**
     * Add bulk form param to request
     *
     * @param qParam bulk params as map object
     */
    protected void addFormParams(Map<String, Object> qParam){
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.formParams(qParam);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{} added to request as form param", qParam);
    }

    /**
     * Add form param to request
     *
     * @param key   is param key as string.
     * @param value is param value as object.
     */
    protected void addFormParam(String key, Object value){
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.formParam(key, value);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        var stringValue = String.valueOf(value);
        log.info(LOG_INFO, key, stringValue);
    }

    /**
     * Add bulk form param to request
     *
     * @param key   is param key as string.
     * @param value is param value as object.
     */
    protected void addFormParams(String key, Object value) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.formParams(key, value);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        var stringValue = String.valueOf(value);
        log.info(LOG_INFO, key, stringValue);
    }
}
