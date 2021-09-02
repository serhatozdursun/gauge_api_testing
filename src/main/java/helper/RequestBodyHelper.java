package helper;


import enums.RequestInfo;
import exceptions.RequestNotDefined;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;
import utils.Utils;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

public class RequestBodyHelper extends ApiHelper {

    private final Logger log = LogManager.getLogger(RequestBodyHelper.class);


    /**
     * Add payload to request.
     *
     * @param body is request body as object
     * @throws RequestNotDefined if request is null, the exception will throw
     */
    public void addBody(Object body) throws RequestNotDefined {
        Utils utils = new Utils();
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.body(body);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("Body added to request \n Body detail: {}", utils.prettyPrint(String.valueOf(body)));
    }

    /**
     * Add payload to request.
     *
     * @param body is request body as Map
     * @throws RequestNotDefined if request is null, the exception will throw
     */
    public void addBody(Map<Object, Object> body) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.body(body);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("Body added to request \n Body detail: {}", body);
    }

    /**
     * Add payload to request.
     *
     * @param body is request body as String
     * @throws RequestNotDefined if request is null, the exception will throw
     */
    public void addBody(String body) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.body(body);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("Body added to request \n Body detail: {}", body);
    }

    /**
     * Add payload to request.
     *
     * @param body is request body as file
     * @throws RequestNotDefined if request is null, the exception will throw
     */
    public void addBody(File body) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.body(body);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("Body added to request \n Body file path: {}", body.getAbsolutePath());
    }

    /**
     * Add payload to request.
     *
     * @param body is request body as InputStream
     * @throws RequestNotDefined if request is null, the exception will throw
     */
    public void addBody(InputStream body) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.body(body);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("Body added to request \n Body file path: {}", body.toString());
    }
}
