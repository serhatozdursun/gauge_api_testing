package filter;

import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import io.restassured.specification.MultiPartSpecification;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class Filter implements io.restassured.filter.Filter {

    private final Logger log = LogManager.getLogger(Filter.class);
    Integer[] failedStatusCode;

    public Filter(Integer... failedStatusCode) {
        this.failedStatusCode = failedStatusCode;
    }

    /**
     * Bu method da Rest-Assured filter method'unu override ediyoruz ve Rest-Assured
     * Logları'nı log4j2 ile log dosyamıza yazıyoruz.
     *
     * @param reqSpec       Rest-Assured request detayları.
     * @param resSpec       Rest-Assured response detayları.
     * @param filterContext Rest- Assured filter context.
     * @return Rest-Assured response
     */
    @Override
    public Response filter(FilterableRequestSpecification reqSpec,
                           FilterableResponseSpecification resSpec,
                           FilterContext filterContext) {

        Response response = filterContext.next(reqSpec, resSpec);
        int statusCode = response.statusCode();

        if (Arrays.stream(failedStatusCode).anyMatch(i -> i == statusCode)) {
            logErrorStatus(response, reqSpec);
        } else if (Arrays.stream(failedStatusCode).anyMatch(i -> i != statusCode)
                || failedStatusCode.length == 0) {
            logInfoStatus(response, reqSpec);
        }
        return response;
    }

    private String getFileAsString(File file) {
        try {
            return FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            return "null";
        }
    }

    private String getRequestBody(FilterableRequestSpecification reqSpec) {

        Object reqBody;
        String body_type;
        try {
            body_type = reqSpec.getBody().getClass().getName();
        } catch (NullPointerException e) {
            body_type = null;
        }

        if (body_type != null && body_type.equalsIgnoreCase("java.io.File")) {
            reqBody = getFileAsString(reqSpec.getBody());
        } else {
            reqBody = reqSpec.getBody();
        }

        return String.valueOf(reqBody);
    }

    private void logErrorStatus(Response response, FilterableRequestSpecification reqSpec) {
        Utils utils = new Utils();

        log.error("-------------------------------");
        log.error("Methods:");
        log.error(reqSpec.getMethod());

        log.error("-------------------------------");
        log.error("URI:");
        log.error(reqSpec.getURI());

        log.error("-------------------------------");
        log.error("Request Headers:");
        log.error(reqSpec.getHeaders());

        if (reqSpec.getQueryParams().size() > 0) {
            log.error("-------------------------------");
            log.error("Request Query Parameters:");
            for (Map.Entry<String, String> entery : reqSpec.getQueryParams().entrySet()) {
                log.error(entery.getKey() + ":" + entery.getValue());
            }
        }
        if (reqSpec.getFormParams().size() > 0) {
            log.error("-------------------------------");
            log.error("Request Form Parameters:");
            for (Map.Entry<String, String> entery : reqSpec.getFormParams().entrySet()) {
                log.error(entery.getKey() + ":" + entery.getValue());
            }
        }

        if (getRequestBody(reqSpec) != null && getRequestBody(reqSpec).length() > 0) {
            log.error("-------------------------------");
            log.error("Request Body");
            log.error(utils.prettyPrint(getRequestBody(reqSpec)));
        }


        log.error("-------------------------------");
        log.error("Response Status Code");
        log.error(response.statusCode());

        log.error("-------------------------------");
        log.error("Response Headers:");
        log.error(response.getHeaders());

        if (reqSpec.getMultiPartParams().size() > 0) {
            log.error("-------------------------------");
            log.error("Multi-form data:");
            for (MultiPartSpecification params : reqSpec.getMultiPartParams()) {
                log.error(params);
            }
        }

        log.error("-------------------------------");
        log.error(utils.prettyPrint(response.asString()));

    }


    private void logInfoStatus(Response response, FilterableRequestSpecification reqSpec) {

        Utils utils = new Utils();

        log.info("-------------------------------");
        log.info("Methods:");
        log.info(reqSpec.getMethod());

        log.info("-------------------------------");
        log.info("URI:");
        log.info(reqSpec.getURI());

        log.info("-------------------------------");
        log.info("Request Headers:");
        log.info(reqSpec.getHeaders());

        if (reqSpec.getQueryParams().size() > 0) {
            log.info("-------------------------------");
            log.info("Request Query Parameters:");
            for (Map.Entry<String, String> entery : reqSpec.getQueryParams().entrySet()) {
                log.info(entery.getKey() + ":" + entery.getValue());
            }
        }

        if (reqSpec.getFormParams().size() > 0) {
            log.info("-------------------------------");
            log.info("Request Form Parameters:");
            for (Map.Entry<String, String> entery : reqSpec.getFormParams().entrySet()) {
                log.info(entery.getKey() + ":" + entery.getValue());
            }
        }

        if (getRequestBody(reqSpec) != null && !getRequestBody(reqSpec).equalsIgnoreCase("null")) {
            log.info("-------------------------------");
            log.info("Request Body");
            log.info(utils.prettyPrint(getRequestBody(reqSpec)));
        }


        log.info("-------------------------------");
        log.info("Response Status Code");
        log.info(response.statusCode());

        log.info("-------------------------------");
        log.info("Response Headers:");
        log.info(response.getHeaders());

        if (reqSpec.getMultiPartParams().size() > 0) {
            log.info("-------------------------------");
            log.info("Multi-form data:");
            for (MultiPartSpecification params : reqSpec.getMultiPartParams()) {
                log.info(params);
            }
        }

        log.info("-------------------------------");
        log.info("Response Body:");
        log.info(utils.prettyPrint(response.asString()));
    }
}
