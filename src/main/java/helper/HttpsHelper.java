package helper;

import enums.RequestInfo;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;

public class HttpsHelper {
    private final Logger log = LogManager.getLogger(HttpsHelper.class);

    protected void addRelaxedHTTPSValidation(){
        ApiHelper.getInstance().getRequestSpecification().relaxedHTTPSValidation();
        log.info("relaxedHTTPSValidation added");
    }



}
