package helper;

import enums.RequestInfo;
import filter.RestAssuredFilter;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;

public class FilterHelper extends ApiHelper {

    private final Logger log = LogManager.getLogger(FilterHelper.class);


    protected void addCustomLogFilter(Integer... statusCode) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.filter(new RestAssuredFilter(statusCode));
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("Log filters added");
    }

    protected void addFilter(RestAssuredFilter filter) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.filter(filter);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
    }
}
