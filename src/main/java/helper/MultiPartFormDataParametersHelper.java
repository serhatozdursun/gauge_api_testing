package helper;

import enums.RequestInfo;
import exceptions.RequestNotDefined;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;

import java.io.File;

public class MultiPartFormDataParametersHelper extends ApiHelper {

    private final Logger log = LogManager.getLogger(MultiPartFormDataParametersHelper.class);

    public void addMultiPartFormData(File file) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.multiPart(file);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{} add to request as multi-part form data", file.getName());
    }

    public void addMultiPartFormData(String key, File file) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        String mimeType = new FileHelper().getFileMimeType(file);
        request.multiPart(new MultiPartSpecBuilder(file)
                .fileName(file.getName())
                .controlName(key)
                .mimeType(mimeType)
                .build());
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{}={} add to request as multi-part form data", key, file.getName());
    }

    public void addMultiPartFormData(String key, String value) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.multiPart(key, value);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{}={} add to request as multi-part form data", key, value);
    }

    public void addMultiPartFormData(String key, Object object) throws RequestNotDefined {
        checkIfRequestDefined();
        RequestSpecification request = (RequestSpecification) StoreApiInfo.get(RequestInfo.REQUEST.info);
        request.multiPart(key, object);
        StoreApiInfo.put(RequestInfo.REQUEST.info, request);
        log.info("{}={} add to request as multi-part form data", key, object.getClass().getName());
    }
}
