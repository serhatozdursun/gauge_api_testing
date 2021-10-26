package afterBefore;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.StoreApiInfo;

public class AfterMethods {
    private static final Logger log = LogManager.getLogger(AfterMethods.class);

    @BeforeSuite
    public void logSuitEnd(){
        log.info("Test Ended");
    }
    @AfterSuite
    public void logSuitStarts(){
        log.info("Test started");
    }
    @AfterScenario
    public void removeRequestInfo() {
        StoreApiInfo.clear();
        StoreApiInfo.remove();
    }

}
