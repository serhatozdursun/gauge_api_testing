package helper.methods;

import enums.RequestInfo;
import exceptions.RequestNotDefined;
import helper.ApiHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;

public class OptionsHelper extends ApiHelper {

    private final Logger log = LogManager.getLogger(OptionsHelper.class);

    /**
     * Create a options request and update ApiHelper class' response object.
     *
     * @param url url to which the request will be sent
     * @return is request result as response
     * @throws RequestNotDefined if request is undefined, throws this exceptions
     */
    protected Response optionsRequest(String url) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        Response response = request.options(url)
                .then()
                .extract()
                .response();
        StoreApiInfo.put(RequestInfo.RESPONSE.info, response);
        log.info("Options request sent to {}", url);
        return response;
    }

    /**
     * Create a options request and update ApiHelper class' response object.
     *
     * @return is request result as response
     * @throws RequestNotDefined if request is undefined, throws this exceptions
     */
    protected Response optionsRequest() throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        Response response = request.options()
                .then()
                .extract()
                .response();
        StoreApiInfo.put(RequestInfo.RESPONSE.info, response);
        log.info("Options request sent");
        return response;
    }
}
