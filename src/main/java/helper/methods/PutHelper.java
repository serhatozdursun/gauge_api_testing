package helper.methods;

import enums.RequestInfo;
import exceptions.RequestNotDefined;
import helper.ApiHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;

public class PutHelper extends ApiHelper {

    private final Logger log = LogManager.getLogger(PutHelper.class);

    /**
     * Create a put request and update ApiHelper class' response object.
     *
     * @param url url to which the request will be sent
     * @return is request result as response
     * @throws RequestNotDefined if request is undefined, throws this exceptions
     */
    public Response putRequest(String url) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        Response response = request.put(url)
                .then()
                .extract()
                .response();
        StoreApiInfo.put(RequestInfo.RESPONSE.info, response);
        log.info("Put request sent to {}", url);
        return response;
    }

    /**
     * Create a put request and update ApiHelper class' response object.
     *
     * @return is request result as response
     * @throws RequestNotDefined if request is undefined, throws this exceptions
     */
    public Response putRequest() throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        Response response = request.put()
                .then()
                .extract()
                .response();
        StoreApiInfo.put(RequestInfo.RESPONSE.info, response);
        log.info("Put request sent");
        return response;
    }
}
