package imp;

import com.thoughtworks.gauge.Step;
import helper.HttpsHelper;

public class HttpsImp extends HttpsHelper {

    @Step({"Add relaxedHTTPSValidation",
            "Varsayılan https sertifkası ekleyin"})
    public void addRelaxedHTTPSValidationToRequest() {
        addRelaxedHTTPSValidation();
    }
}
