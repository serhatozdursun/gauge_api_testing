package helper;

import enums.RequestInfo;
import exceptions.RequestNotDefined;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;

import java.util.Map;

public class FormParamsHelper extends ApiHelper {

    private final Logger log = LogManager.getLogger(FormParamsHelper.class);

    /**
     * Add form param to request
     *
     * @param key   is param key as string.
     * @param value is param value as string.
     * @throws RequestNotDefined if request is undefined, throws this exceptions
     */
    public void addFormParam(String key, String value) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.formParam(key, value);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{} = {} added to request as form param", key, value);
    }

    /**
     * Add bulk form param to request
     *
     * @param qParam bulk params as map object
     * @throws RequestNotDefined if request is undefined, throws this exceptions
     */
    public void addFormParams(Map<String, Object> qParam) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.formParams(qParam);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{} bulk added to request as form params ", qParam);
    }

    /**
     * Add form param to request
     *
     * @param key   is param key as string.
     * @param value is param value as object.
     * @throws RequestNotDefined if request is undefined, throws this exceptions
     */
    public void addFormParam(String key, Object value) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.formParam(key, value);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{} = {} added to request as form param", key, String.valueOf(value));
    }

    /**
     * Add bulk form param to request
     *
     * @param key   is param key as string.
     * @param value is param value as object.
     * @throws RequestNotDefined if request is undefined, throws this exceptions
     */
    public void addFormParams(String key, Object value) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.formParams(key, value);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{} = {} added to request as form param", key, String.valueOf(value));
    }
}
