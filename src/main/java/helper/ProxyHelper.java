package helper;

import enums.RequestInfo;
import exceptions.RequestNotDefined;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;

import java.net.URI;

public class ProxyHelper extends ApiHelper {

    private final Logger log = LogManager.getLogger(ProxyHelper.class);
    private static final String LOG_INFO = "{} added as proxy";

    public void proxy(int proxy) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.proxy(proxy);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info(LOG_INFO, proxy);
    }

    public void proxy(String var1, int var2) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.proxy(var1, var2);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{}, {} added as proxy", var1, var2);
    }

    public void proxy(String var1) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.proxy(var1);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info(LOG_INFO, var1);
    }

    public void proxy(String var1, int var2, String var3) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.proxy(var1, var2, var3);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{},{},{} added as proxy", var1, var2, var3);
    }

    public void proxy(URI var1) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.proxy(var1);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info(LOG_INFO, var1);
    }

    public void proxy(ProxySpecification var1) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.proxy(var1).auth();
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
    }
}
