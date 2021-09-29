package helper;

import configuration.Configuration;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DBConnectionHelper {

    public Map<String, Object> connectDB(String query) throws SQLException, ClassNotFoundException {
        String dbClass = Configuration.getInstance().getDbClass();
        String dbUser = Configuration.getInstance().getDbUser();
        String dbPassword = Configuration.getInstance().getDbPassword();
        String connectionString = Configuration.getInstance().getConnectionString();
        Class.forName(dbClass);
        Connection con = DriverManager.getConnection(connectionString, dbUser, dbPassword);
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rm = rs.getMetaData();
        Map<String, Object> source = new HashMap<>();
        source.put("ResultSet", rs);
        source.put("MetaData", rm);
        source.put("Connection", con);
        source.put("Statement", stmt);
        return source;
    }
}
