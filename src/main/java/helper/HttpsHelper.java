package helper;

import enums.RequestInfo;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;

public class HttpsHelper  extends ApiHelper {
    private final Logger log = LogManager.getLogger(HttpsHelper.class);

    public void addRelaxedHTTPSValidation(){
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.relaxedHTTPSValidation();
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("relaxedHTTPSValidation added");
    }



}
