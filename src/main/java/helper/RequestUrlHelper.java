package helper;


import enums.RequestInfo;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.LogManager;
import utils.StoreApiInfo;

public class RequestUrlHelper extends ApiHelper {

    private final Logger log = LogManager.getLogger(RequestUrlHelper.class);

    public void addBaseUrl(String baseUrl) {
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.baseUri(baseUrl);
        log.info("{} added as a base url", baseUrl);
    }

    public void addBasePath(String endpoint) {
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.basePath(endpoint);
        log.info("{} added as a base path", endpoint);
    }
}
