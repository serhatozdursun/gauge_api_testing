package imp;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.datastore.ScenarioDataStore;
import exceptions.RequestNotDefined;
import helper.QueryParamsHelper;
import utils.Utils;

import java.util.HashMap;

public class QueryParamImp extends QueryParamsHelper {



    @Step({"Add query parameter <key> = <value>.", "Query parametresi ekle <key> = <value>."})
    public void addQueryParamsToReq(String key, String value) throws RequestNotDefined {
        addQueryParam(key, value);
    }

    @Step({"Add query parameter <key> = <object value>", "Query parametresi ekle <key> = <object value>"})
    public void addQueryParamsToReq(String key, Object value) throws RequestNotDefined {
        addQueryParam(key, value);
    }

    @Step({"Add query parameter <table>", "Query parametresi ekle <table>"})
    public void addQueryParamsToReq(Table table) throws RequestNotDefined {
        Utils utils = new Utils();
        HashMap<String, Object> params = utils.gaugeDataTableToMap(table);
        addQueryParams(params);
    }

    @Step({"Add query parameter from scenario store with <key>",
            "<key> anahtarı ile saklanan datalardan değeri al query parametresi olarak ekle."})
    public void addQueryParamsfromStore(String key) throws RequestNotDefined {
            Object params =  ScenarioDataStore.get(key);
            addQueryParams(key,params);
    }
}
