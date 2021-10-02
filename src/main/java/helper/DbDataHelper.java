package helper;

import configuration.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DbDataHelper {

    private static final Logger log = LogManager.getLogger(DbDataHelper.class);
    private String query = "";

    public HashMap<String, Object> getQueResult(String queryName) throws SQLException, ClassNotFoundException, IOException {
        String dbClass = Configuration.getInstance().getDbClass();
        String dbUser = Configuration.getInstance().getDbUser();
        String dbPassword = Configuration.getInstance().getDbPassword();
        String connectionString = Configuration.getInstance().getConnectionString();
        var result = new HashMap<String, Object>();
        setQuery(queryName);
        try {
            Class.forName(dbClass);
            Connection con = DriverManager.getConnection(connectionString, dbUser, dbPassword);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rm = rs.getMetaData();
            int countOfColumn = rm.getColumnCount();
            while (rs.next()) {
                if (countOfColumn == 1) {
                    for (int i = 1; i <= rm.getColumnCount(); ++i) {
                        result.put(rm.getColumnName(i), rs.getObject(i));
                    }
                } else {
                    for (int i = 1; i <= rm.getColumnCount(); ++i) {
                        result.put(rm.getColumnName(i) + "_i", rs.getObject(i));
                    }
                }
            }
            con.close();
            stmt.close();
            rs.close();
        } catch (SQLException | ClassNotFoundException e) {
            log.fatal("Sql exception occurred queryName: {}\nconnection string: {}\n message: {}",
                    queryName, connectionString, e.getMessage());
            throw e;
        }
        return result;
    }


    protected void setQuery(String queryName) {
        var fileContents = getFileContentAsList();

        IntStream.range(0, fileContents.size())
                .forEach(index -> Arrays.stream(fileContents.get(index).split("--"))
                        .forEach(queries -> {
                            if (queries.contains(queryName)) {
                                query = queries.replaceAll(queryName, "");
                                query = query.replaceAll("\\n", " ");
                            }
                        }));

    }


    private List<String> getFileContentAsList()  {
        List<Path> files;
        files = allQueries();
        List<String> fileList = new ArrayList<>();
        files.forEach(path -> {
            byte[] file = new byte[0];
            try {
                file = Files.readAllBytes(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileList.add(new String(file));
        });
        return fileList;
    }

    private List<Path> allQueries() {
        List<Path> files = new ArrayList<>();
        Path path = Path.of(Objects.requireNonNull(getClass().getClassLoader().getResource("sqlQueries"))
                .getPath());
        try (Stream<Path> walk = Files.walk(path)) {
            files = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }

}
