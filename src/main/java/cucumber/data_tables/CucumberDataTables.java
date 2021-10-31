package cucumber.data_tables;

import helper.ParseHelper;
import io.cucumber.java.DataTableType;
import org.jetbrains.annotations.NotNull;
import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CucumberDataTables {

    @DataTableType
    public Map<String, Object> parameters(@NotNull Map<String, String> entry) {
        var params = new HashMap<String, Object>();
        entry.forEach((key, value) -> params.put(key, new Utils().isNumeric(value) ?
                new ParseHelper().parsStringToInt(value) :
                value));
        return params;
    }

}
