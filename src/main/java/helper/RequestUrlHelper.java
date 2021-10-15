package helper;


import enums.RequestInfo;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.LogManager;
import utils.StoreApiInfo;

public class RequestUrlHelper {

    private final Logger log = LogManager.getLogger(RequestUrlHelper.class);

    protected void addBaseUrl(String baseUrl) {
        ApiHelper.getInstance().getRequestSpecification().baseUri(baseUrl);
        log.info("{} added as a base url", baseUrl);
    }

    protected void addBasePath(String endpoint) {
        ApiHelper.getInstance().getRequestSpecification().basePath(endpoint);
        log.info("{} added as a base path", endpoint);
    }
}
