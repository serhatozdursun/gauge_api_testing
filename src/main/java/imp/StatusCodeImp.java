package imp;

import com.thoughtworks.gauge.Step;
import exceptions.NullResponse;
import helper.StatusCodeHelper;

public class StatusCodeImp extends StatusCodeHelper {

    @Step({"Check if status code is <code>", "Statü kodunu kontrol et <kod> mü?"})
    public void checkStatusCodeFromRes(Integer key) throws NullResponse {
        checkStatusCode(key);
    }
}
