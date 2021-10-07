package helper;

import enums.RequestInfo;
import exceptions.NullResponse;
import exceptions.RequestNotDefined;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;

import static enums.RequestInfo.REQUEST;

public class ApiHelper {


    private final Logger log = LogManager.getLogger(ApiHelper.class);

    /**
     * Check if undefined request
     *
     * @throws RequestNotDefined if request is undefined this exception will throw
     */
    protected void checkIfRequestDefined() throws RequestNotDefined {

        if (StoreApiInfo.get(REQUEST.info) == null) {
            log.error("Tanımlı bir request yok.");
            throw new RequestNotDefined();
        }
    }

    /**
     * response Check if response is null.
     *
     * @throws NullResponse if response is null this exception will throw
     */
    protected void checkIfResponseNull() throws NullResponse {
        if (StoreApiInfo.get(RequestInfo.RESPONSE.info) == null) {
            log.error("Response yok.");
            throw new NullResponse();
        }
    }

    protected RequestSpecification defineNewRequest() {
        StoreApiInfo.remove(RequestInfo.RESPONSE.info);
        StoreApiInfo.remove(REQUEST.info);
        var request = RestAssured.given();
        StoreApiInfo.put(REQUEST.info, request);
        return (RequestSpecification) StoreApiInfo.get(REQUEST.info);
    }

    protected void defineNewRequestIfNull() {
        if (StoreApiInfo.get(REQUEST.info) == null) {
            defineNewRequest();
        }
    }


}
