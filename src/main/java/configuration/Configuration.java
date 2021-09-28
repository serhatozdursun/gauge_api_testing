package configuration;


import enums.PropertiesType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static Configuration instance;
    Properties configProps;
    protected static final Logger log = LogManager.getLogger(Configuration.class);
    static final String PROP_FILE_NAME = "properties/config.properties";
    private String slackToken;
    private String connectionString;
    private String dbClass;
    private String dbPassword;
    private String dbUser;

    public static Configuration getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    private static synchronized void createInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
    }

    private Configuration() {

        try (InputStream is = ClassLoader.getSystemResourceAsStream(PROP_FILE_NAME)) {
            configProps = new Properties();
            configProps.load(is);
            this.slackToken = configProps.getProperty(PropertiesType.SLACK_TOKEN.getText());
            this.connectionString = configProps.getProperty(PropertiesType.CONNECTION_STRING.getText());
            this.dbClass = configProps.getProperty(PropertiesType.DB_CLASS.getText());
            this.dbUser = configProps.getProperty(PropertiesType.DB_USER.getText());
            this.dbPassword = configProps.getProperty(PropertiesType.DB_PASSWORD.getText());
        } catch (Exception e) {
            log.error(e);
        } finally {
            log.info("Properties read finished.");
        }
    }


    public String getSlackToken() {
        return slackToken;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public String getDbClass() {
        return dbClass;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbUser() {
        return dbUser;
    }


}