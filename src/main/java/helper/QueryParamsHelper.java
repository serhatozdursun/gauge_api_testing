package helper;

import enums.RequestInfo;
import exceptions.RequestNotDefined;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;

import java.util.Map;

public class QueryParamsHelper extends ApiHelper {

    private final Logger log = LogManager.getLogger(QueryParamsHelper.class);

    /**
     * Add query param to request
     *
     * @param key   is param key as string.
     * @param value is param value as string.
     * @throws RequestNotDefined if request is undefined, throws this exceptions
     */
    public void addQueryParam(String key, String value) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.queryParam(key, value);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{} = {} added to request as query param", key, value);
    }

    /**
     * Add bulk query param to request
     *
     * @param qParam bulk params as map object
     * @throws RequestNotDefined if request is undefined, throws this exceptions
     */
    public void addQueryParams(Map<String, Object> qParam) throws RequestNotDefined {
        checkIfRequestDefined();
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
     * @throws RequestNotDefined if request is undefined, throws this exceptions
     */
    public void addQueryParam(String key, Object value) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.queryParam(key, value);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{} = {} added to request as query param", key, String.valueOf(value));
    }

    /**
     * Add bulk query param to request
     *
     * @param key   is param key as string.
     * @param value is param value as object.
     * @throws RequestNotDefined if request is undefined, throws this exceptions
     */
    public void addQueryParams(String key, Object value) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.queryParams(key, value);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{} = {} added to request as query param", key, String.valueOf(value));
    }
}
