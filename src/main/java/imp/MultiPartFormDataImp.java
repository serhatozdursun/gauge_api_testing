package imp;

import com.thoughtworks.gauge.Step;
import helper.MultiPartFormDataParametersHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class MultiPartFormDataImp extends MultiPartFormDataParametersHelper {

    private final Logger log = LogManager.getLogger(MultiPartFormDataImp.class);

    @Step("Get \"<file>\" file and add to request as multi-part form data")
    public void addMultiPartFormDataToRequest(String filePath) {
        try {
            addMultiPartFormData(new File(filePath));
        } catch (Exception e) {
            log.fatal("An error occurred file path {} and error message is {}", filePath, e.getMessage());
        }
    }

    @Step("Get <file> file and add to request with key <key> as multi-part form data")
    public void addMultiPartFormDataToRequest(String filePath, String key) {
        File file = new File("src/test/resources/" + filePath);
        try {
            addMultiPartFormData(key, file);
        } catch (Exception e) {
            log.fatal("An error occurred when trying to add {} and {}, error message is {}",
                    key, file.getPath(), e.getMessage());
        }
    }

    @Step("Add to request <key> = <object> as multi-part form data")
    public void addMultiPartFormDataToRequest(String key, Object obj) {
        try {
            addMultiPartFormData(key, obj);
        } catch (Exception e) {
            log.fatal("An error occurred when trying to add {} and {}, error message is {}\"",
                    key, obj.getClass().getName(), e.getMessage());
        }
    }

    @Step("Add to request <key>=<value> as multi-part form data")
    public void addMultiPartFormDataToRequestAsString(String key, String value) {
        try {
            addMultiPartFormData(key, value);
        } catch (Exception e) {
            log.fatal("An error occurred when trying to add {} and {}, error message is {}",
                    key, value,e.getMessage());
        }
    }
}
