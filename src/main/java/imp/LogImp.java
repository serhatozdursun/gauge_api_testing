package imp;


import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import com.thoughtworks.gauge.datastore.ScenarioDataStore;
import exceptions.RequestNotDefined;
import helper.FilterHelper;
import helper.ParseHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class LogImp {


    private final Logger log = LogManager.getLogger(LogImp.class);

    @Step({"Add log filter with errorStatus <table>", "Bu statü kodları için log filtresi ekle <table>"})
    public void addFilter(Table table) throws RequestNotDefined {
        ParseHelper parseHelper = new ParseHelper();
        FilterHelper filterHelper = new FilterHelper();
        List<TableRow> rows = table.getTableRows();
        ArrayList<Integer> statusCodes = new ArrayList<>();

        for (TableRow row : rows) {
            int statusCode = parseHelper.parsStringToInt(row.getCellValues().get(0));
            statusCodes.add(statusCode);
        }

        Integer[] status = new Integer[statusCodes.size()];
        statusCodes.toArray(status);
        filterHelper.addCustomLogFilter(status);
    }

    @Step({"Log <log>", "Logla <log>"})
    public void startLog(String log) {
        this.log.info(log);
    }

    @Step({"Log this param <key>", "Kayıtlı parametreyi logla <key>"})
    public void logThisParam(String key) {
        this.log.info(ScenarioDataStore.get(key));
    }
}
