package imp;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import helper.FormParamsHelper;

import java.util.HashMap;
import java.util.List;

public class FormParamImp extends FormParamsHelper {

    @Step({"Add form parameter <key> = <value>", "Form parametresi ekle <key> = <value>"})
    public void addFormParamToReq(String key, String value){
        addFormParam(key, value);
    }

    @Step({"Add form parameters <key> = <object type value>", "Form parametrelerini ekle <key> = <object type value> "})
    public void addFormParamToReq(String key, Object value) {
        addFormParam(key, value);
    }

    @Step({"Add form parameters <key> = <object type value>", "Form parametersi ekleyin <key> = <object type value>"})
    public void addFormParamsToReq(String key, Object value){
        addFormParams(key, value);
    }

    @Step({"Add form parameters <table>", "Form parametrelerini ekle <table>"})
    public void addFormParamToReq(Table table){
        List<TableRow> rows = table.getTableRows();
        HashMap<String, Object> parameters = new HashMap<>();
        for (TableRow row : rows) {
            parameters.put(row.getCellValues().get(0), row.getCellValues().get(1));
        }
        addFormParams(parameters);
    }


}
