package imp;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.ScenarioDataStore;
import com.thoughtworks.gauge.datastore.SpecDataStore;
import com.thoughtworks.gauge.datastore.SuiteDataStore;
import helper.DBConnectionHelper;
import helper.GetQueryHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.Map;

public class GetQueryResultImp extends DBConnectionHelper {

    private static final Logger log = LogManager.getLogger(GetQueryResultImp.class);
    private String query;

    @Step({"Get column <columnName> data from query <queryName> result and save in scenario store",
            "Query <queryName> sorgusu sonucundan <columnName> sütun verisini deposunda sakla"})
    public String GetQueryResultAndSaveValueWithColumnName(String columnName, String queryName) throws SQLException, ClassNotFoundException {
        setQuery(queryName);
        Map<String, Object> results = connectDB(query);
        ResultSetMetaData md = (ResultSetMetaData) results.get("MetaData");
        ResultSet rs = (ResultSet) results.get("ResultSet");

        int columns = md.getColumnCount();

        String result = "";
        while (rs.next()) {
            for (int i = 1; i <= columns; ++i) {
                if (md.getColumnName(i).equalsIgnoreCase(columnName)) {
                    result = String.valueOf(rs.getObject(i));
                    ScenarioDataStore.put(md.getColumnName(i), String.valueOf(rs.getObject(i)));
                    log.info("Stored data key {}, value{}", md.getColumnName(i), rs.getObject(i));
                }
            }
        }
        ((Connection) results.get("Connection")).close();
        ((ResultSet) results.get("ResultSet")).close();
        ((Statement) results.get("Statement")).close();
        return result;
    }

    @Step({"Get column <columnName> data from query <queryName> result and save in spec store",
            "Query <queryName> sorgusu sonucundan <columnName> sütun verilerisini spec deposunda sakla"})
    public String GetQueryResultAndSaveValueWithColumnNameForSpecStore(String columnName, String queryName) throws SQLException, ClassNotFoundException {
        setQuery(queryName);
        Map<String, Object> results = connectDB(query);
        ResultSetMetaData md = (ResultSetMetaData) results.get("MetaData");
        ResultSet rs = (ResultSet) results.get("ResultSet");

        int columns = md.getColumnCount();

        String result = "";
        while (rs.next()) {
            for (int i = 1; i <= columns; ++i) {
                if (md.getColumnName(i).equalsIgnoreCase(columnName)) {
                    result = String.valueOf(rs.getObject(i));
                    SpecDataStore.put(md.getColumnName(i), String.valueOf(rs.getObject(i)));
                    log.info("Stored data key {}, value{}", md.getColumnName(i), rs.getObject(i));
                }
            }
        }
        ((Connection) results.get("Connection")).close();
        ((ResultSet) results.get("ResultSet")).close();
        ((Statement) results.get("Statement")).close();
        return result;
    }

    @Step({"Get column <columnName> data from query <queryName> result and save in suit store",
            "Query <queryName> sorgusu sonucundan <columnName> sütun verilerisini suit deposunda sakla"})
    public String GetQueryResultAndSaveValueWithColumnNameForSuitStore(String columnName, String queryName) throws SQLException, ClassNotFoundException {
        setQuery(queryName);
        Map<String, Object> results = connectDB(query);
        ResultSetMetaData md = (ResultSetMetaData) results.get("MetaData");
        ResultSet rs = (ResultSet) results.get("ResultSet");

        int columns = md.getColumnCount();

        String result = "";
        while (rs.next()) {
            for (int i = 1; i <= columns; ++i) {
                if (md.getColumnName(i).equalsIgnoreCase(columnName)) {
                    result = String.valueOf(rs.getObject(i));
                    SuiteDataStore.put(md.getColumnName(i), String.valueOf(rs.getObject(i)));
                    log.info("Stored data key {}, value{}", md.getColumnName(i), rs.getObject(i));
                }
            }
        }
        ((Connection) results.get("Connection")).close();
        ((ResultSet) results.get("ResultSet")).close();
        ((Statement) results.get("Statement")).close();
        return result;
    }

    @Step({"Get column data from query <queryName> result and save all column data in suit store with column name",
            "Query <queryName> sorgusu sonucundan dönen tüm datayı kolon isimleriyle birlikte senaryo deposunda sakla"})
    public String GetQueryResultAndSaveValueForAllColumnAndStoreScenarioStore(String queryName) throws SQLException, ClassNotFoundException {
        setQuery(queryName);
        Map<String, Object> results = connectDB(query);
        ResultSetMetaData md = (ResultSetMetaData) results.get("MetaData");
        ResultSet rs = (ResultSet) results.get("ResultSet");

        int columns = md.getColumnCount();

        String result = "";
        while (rs.next()) {
            for (int i = 1; i <= columns; ++i) {
                result = String.valueOf(rs.getObject(i));
                ScenarioDataStore.put(md.getColumnName(i), result);
                log.info("Stored data key {}, value{}", md.getColumnName(i), rs.getObject(i));

            }
        }
        ((Connection) results.get("Connection")).close();
        ((ResultSet) results.get("ResultSet")).close();
        ((Statement) results.get("Statement")).close();
        return result;
    }

    @Step({"Get column data from query <queryName> result and save all column data in spec store with column name",
            "Query <queryName> sorgusu sonucundan dönen tüm datayı kolon isimleriyle birlikte spec deposunda sakla"})
    public String GetQueryResultAndSaveValueForAllColumnAndStoreSpecStore(String queryName) throws SQLException, ClassNotFoundException {
        setQuery(queryName);
        Map<String, Object> results = connectDB(query);
        ResultSetMetaData md = (ResultSetMetaData) results.get("MetaData");
        ResultSet rs = (ResultSet) results.get("ResultSet");

        int columns = md.getColumnCount();

        String result = "";
        while (rs.next()) {
            for (int i = 1; i <= columns; ++i) {
                result = String.valueOf(rs.getObject(i));
                SpecDataStore.put(md.getColumnName(i), result);
                log.info("Stored data key {}, value{}", md.getColumnName(i), rs.getObject(i));

            }
        }
        ((Connection) results.get("Connection")).close();
        ((ResultSet) results.get("ResultSet")).close();
        ((Statement) results.get("Statement")).close();
        return result;
    }

    @Step({"Get column data from query <queryName> result and save all column data in spec store with column name",
            "Query <queryName> sorgusu sonucundan dönen tüm datayı kolon isimleriyle birlikte spec deposunda sakla"})
    public String GetQueryResultAndSaveValueForAllColumnAndStoreSuitStore(String queryName) throws SQLException, ClassNotFoundException {
        setQuery(queryName);
        Map<String, Object> results = connectDB(query);
        ResultSetMetaData md = (ResultSetMetaData) results.get("MetaData");
        ResultSet rs = (ResultSet) results.get("ResultSet");

        int columns = md.getColumnCount();

        String result = "";
        while (rs.next()) {
            for (int i = 1; i <= columns; ++i) {
                result = String.valueOf(rs.getObject(i));
                SuiteDataStore.put(md.getColumnName(i), result);
                log.info("Stored data key {}, value{}", md.getColumnName(i), rs.getObject(i));

            }
        }
        ((Connection) results.get("Connection")).close();
        ((ResultSet) results.get("ResultSet")).close();
        ((Statement) results.get("Statement")).close();
        return result;
    }

    private void setQuery(String queryName) {
        try {
            query = new GetQueryHelper().getQueryName(queryName);
        } catch (IOException e) {
            log.fatal("Query could not find");
        }
    }
}
