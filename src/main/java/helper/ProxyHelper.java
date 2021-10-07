package helper;

import enums.RequestInfo;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;

import java.net.URI;

public class ProxyHelper extends ApiHelper {

    private final Logger log = LogManager.getLogger(ProxyHelper.class);
    private static final String LOG_INFO = "{} added as proxy";

    protected void proxy(int proxy) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.proxy(proxy);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info(LOG_INFO, proxy);
    }

    protected void proxy(String var1, int var2) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.proxy(var1, var2);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{}, {} added as proxy", var1, var2);
    }

    protected void proxy(String var1) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.proxy(var1);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info(LOG_INFO, var1);
    }

    protected void proxy(String var1, int var2, String var3) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.proxy(var1, var2, var3);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{},{},{} added as proxy", var1, var2, var3);
    }

    protected void proxy(URI var1) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.proxy(var1);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info(LOG_INFO, var1);
    }

    protected void proxy(ProxySpecification var1) {
        defineNewRequestIfNull();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.proxy(var1).auth();
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
    }
}
