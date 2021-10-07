package helper;

import enums.RequestInfo;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;

import java.util.Map;

public class QueryParamsHelper extends ApiHelper {

    private final Logger log = LogManager.getLogger(QueryParamsHelper.class);
    private static final String LOG_INFO = "{} = {} added to request as query param";
    /**
     * Add query param to request
     *
     * @param key   is param key as string.
     * @param value is param value as string.
     */
    protected void addQueryParam(String key, String value) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.queryParam(key, value);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info(LOG_INFO, key, value);
    }

    /**
     * Add bulk query param to request
     *
     * @param qParam bulk params as map object
     */
    protected void addQueryParams(Map<String, Object> qParam) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.queryParams(qParam);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{} bulk added to request as query params ", qParam);
    }

    /**
     * Add query param to request
     *
     * @param key   is param key as string.
     * @param value is param value as object.
     */
    protected void addQueryParam(String key, Object value) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.queryParam(key, value);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        var stringValue = String.valueOf(value);
        log.info(LOG_INFO, key, stringValue);
    }

    /**
     * Add bulk query param to request
     *
     * @param key   is param key as string.
     * @param value is param value as object.
     */
    protected void addQueryParams(String key, Object value) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.queryParams(key, value);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        var stringValue = String.valueOf(value);
        log.info(LOG_INFO, key, stringValue);
    }
}
