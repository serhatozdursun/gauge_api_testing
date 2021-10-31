package imp.methods;

import com.thoughtworks.gauge.Step;
import exceptions.RequestNotDefined;
import helper.methods.GetHelper;
import io.cucumber.java.en.When;

public class GetRequestImp extends GetHelper {

    @Step({"Get request", "Get isteği gönder"})
    @When("Send get request")
    public void getRequests() throws RequestNotDefined {
        getRequest();
    }

    @Step({"Get request <url>", "Get isteği gönder <url>"})
    @When("Send get request {string}")
    public void getRequests(String url) throws RequestNotDefined {
        getRequest(url);
    }
}
