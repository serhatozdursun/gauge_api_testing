package imp.methods;

import com.thoughtworks.gauge.Step;
import exceptions.RequestNotDefined;
import helper.methods.GetHelper;

public class GetRequestImp extends GetHelper {

    @Step({"Get request", "Get isteği gönder"})
    public void getRequests() throws RequestNotDefined {
        getRequest();
    }

    @Step({"Get request <url>", "Get isteği gönder <url>"})
    public void getRequests(String url) throws RequestNotDefined {
        getRequest(url);
    }
}
