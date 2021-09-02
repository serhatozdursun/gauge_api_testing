package imp;

import com.thoughtworks.gauge.Step;
import helper.ApiHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class RequestImp extends ApiHelper {

    private final Logger log = LogManager.getLogger(RequestImp.class);

    @Step({"Define new request", "Yeni bir api isteği tanımla"})
    public void defineNewApiRequest() {
        defineNewRequest();
        log.info("New request defined");
    }
}
