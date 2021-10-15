package helper;

import enums.RequestInfo;
import filter.RestAssuredFilter;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;

public class FilterHelper {

    private final Logger log = LogManager.getLogger(FilterHelper.class);


    protected void addCustomLogFilter(Integer... statusCode) {
        ApiHelper.getInstance().getRequestSpecification().filter(new RestAssuredFilter(statusCode));
    }

    protected void addFilter(RestAssuredFilter filter) {
        ApiHelper.getInstance().getRequestSpecification().filter(filter);
    }
}
