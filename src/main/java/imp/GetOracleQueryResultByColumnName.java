package imp;

import com.thoughtworks.gauge.Step;
import helper.DBConnectionHelper;
import helper.GetQueryHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.Map;

public class GetOracleQueryResultByColumnName extends DBConnectionHelper {

    private static final Logger log = LogManager.getLogger(GetOracleQueryResultByColumnName.class);

    @Step({"Get column <columnName> data from query <queryName> result",
            "Query <queryName> sorgusu sonucundan <columnName> sütun verilerini alın"})
    public String run(String columnName, String queryName) throws SQLException, ClassNotFoundException, IOException {
        String query = new GetQueryHelper().getQueryName(queryName);
        Map<String, Object> results = connectDB(query);
        ResultSetMetaData md = (ResultSetMetaData) results.get("MetaData");
        ResultSet rs = (ResultSet) results.get("ResultSet");

        int columns = md.getColumnCount();

        String result = "";
        while (rs.next()) {
            for (int i = 1; i <= columns; ++i) {
                if (md.getColumnName(i).equalsIgnoreCase(columnName)) {
                    result = String.valueOf(rs.getObject(i));
                    log.info("Stored data key {}, value{}", md.getColumnName(i), rs.getObject(i));
                }
            }
        }
        ((Connection) results.get("Connection")).close();
        ((ResultSet) results.get("ResultSet")).close();
        ((Statement) results.get("Statement")).close();
        return result;
    }
}
