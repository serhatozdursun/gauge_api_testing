package imp;


import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import exceptions.RequestNotDefined;
import helper.HeaderHelper;
import utils.Utils;

import java.util.Map;


public class HeaderImp extends HeaderHelper {


    @Step({"Add as a header <key> = <value>", "Header ekle <key> = <value>"})
    public void addHeaderToReq(String key, String value) throws RequestNotDefined {
        addHeader(key, value);
    }

    @Step({"Add Headers <table>", "Header Ekle <TableRow>"})
    public void addHeadersToReq(Table table) throws RequestNotDefined {
        Utils utils = new Utils();
        Map<String, Object> headers = utils.gaugeDataTableToMap(table);
        addHeaders(headers);
    }

    @Step({"Add SOAPAction <action>", "SOAPAction ekle <action>"})
    public void addSOAPActionToReq(String action) throws RequestNotDefined {
        addSOAPAction(action);
    }

    @Step({"Add multi-part data as content-type to header with default boundary <boundary>"})
    public void addMultipleDataContentTypeAsHeader(String boundary) throws RequestNotDefined {
        addMultiPartContentType(boundary);
    }


}
