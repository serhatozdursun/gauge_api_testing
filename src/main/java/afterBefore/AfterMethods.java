package afterBefore;

import com.thoughtworks.gauge.AfterScenario;
import utils.StoreApiInfo;

public class AfterMethods {

    @AfterScenario
    public void removeRequestInfo() {
        StoreApiInfo.clear();
        StoreApiInfo.remove();
    }
}
