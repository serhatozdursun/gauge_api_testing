package imp;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.datastore.ScenarioDataStore;
import exceptions.RequestNotDefined;
import helper.PathParameterHelper;
import utils.Utils;

import java.util.Map;

public class PathParamImp extends PathParameterHelper {



    @Step({"Add path parameter <key> = <value>.", "Path parametresi ekle <key> = <value>."})
    public void addPathParamsToReq(String key, String value) throws RequestNotDefined {
        addPathParam(key, value);
    }

    @Step({"Add path parameter <key> = <object value>", "Path parametresi ekle <key> = <object value>"})
    public void addPathParamsToReq(String key, Object value) throws RequestNotDefined {
        addPathParam(key, value);
    }

    @Step({"Add path parameter <table>", "Path parametresi ekle <table>"})
    public void addPathParamsToReq(Table table) throws RequestNotDefined {
        Utils utils = new Utils();
        Map<String, Object> params = utils.gaugeDataTableToMap(table);
        addPathParams(params);
    }

    @Step({"Add path parameter from scenario store with <key>",
            "<key> anahtarı ile saklanan datalardan değeri al path parametresi olarak ekle."})
    public void addPathParaFromStore(String key) throws RequestNotDefined {
        Object params =  ScenarioDataStore.get(key);
        addPathParams(key,params);
    }
}
