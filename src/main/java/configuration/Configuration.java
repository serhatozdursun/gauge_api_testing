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
        } catch (Exception e) {
            log.error(e);
        } finally {
            log.info("Properties read finished.");
        }
    }


    public String getSlackToken() {
        return slackToken;
    }

}