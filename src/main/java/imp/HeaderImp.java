package imp;


import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import exceptions.RequestNotDefined;
import helper.HeaderHelper;
import io.cucumber.java.en.Given;
import utils.Utils;

import java.util.Map;


public class HeaderImp extends HeaderHelper {


    @Step({"Add as a header <key> = <value>", "Header ekle <key> = <value>"})
    @Given("Add as a header {string} = {string}")
    public void addHeaderToReq(String key, String value) {
        addHeader(key, value);
    }

    @Step({"Add Headers <table>", "Header Ekle <TableRow>"})
    public void addHeadersToReq(Table table) {
        Utils utils = new Utils();
        Map<String, Object> headers = utils.gaugeDataTableToMap(table);
        addHeaders(headers);
    }

    @Given("Headers")
    public void addFormParametersFromTable(Map<String, Object> map) {
        addHeaders(map);
    }

    @Step({"Add SOAPAction <action>", "SOAPAction ekle <action>"})
    @Given("SOAPAction {string}")
    public void addSOAPActionToReq(String action) throws RequestNotDefined {
        addSOAPAction(action);
    }

    @Step({"Add multi-part data as content-type to header with default boundary <boundary>",
            "Multi-part verileri, ekleyin header varsayılan boundary <boundary> ile"})
    @Given("Multi-part data as content-type to header with default boundary {string}")
    public void addMultipleDataContentTypeAsHeader(String boundary) {
        addMultiPartContentType(boundary);
    }


}
