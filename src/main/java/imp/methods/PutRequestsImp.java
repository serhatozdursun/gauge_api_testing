package imp.methods;

import com.thoughtworks.gauge.Step;
import exceptions.RequestNotDefined;
import helper.methods.PutHelper;
import io.cucumber.java.en.When;

public class PutRequestsImp extends PutHelper {

    @Step({"Put request", "Put isteği gönder"})
    @When("Put request")
    public void putRequests() throws RequestNotDefined {
        putRequest();
    }

    @Step({"Put request <url>", "Put isteği gönder <url>"})
    @When("Put request {string}")
    public void putRequests(String url) throws RequestNotDefined {
        putRequest(url);
    }
}
