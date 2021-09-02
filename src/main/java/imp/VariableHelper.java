package imp;


import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.datastore.ScenarioDataStore;
import com.thoughtworks.gauge.datastore.SpecDataStore;
import com.thoughtworks.gauge.datastore.SuiteDataStore;
import helper.FileHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Utils;

import java.io.File;
import java.util.HashMap;

public class VariableHelper {

    private final Logger log = LogManager.getLogger(VariableHelper.class);


    @Step({"Store variable <key> = <value> during scenario", "Senaryo boyunca değişkeni sakla <key> = <value>"})
    public void storeVariableDuringScenario(String key, String value) {
        ScenarioDataStore.put(key, value);
        log.info("{}, {} variable stored", key, value);
    }

    @Step({"Store <file name>'s value from classpath with <key> during scenario",
            "Senaryo boyunca <dosya adı> içeriğini <key> anahtarı ile sakla"})
    public void storeVariableDuringScenarioFromFile(String fileName, String key) {
        FileHelper fileHelper = new FileHelper();
        String filePath = getClass().getClassLoader().getResource(fileName).getPath();
        String value = fileHelper.readFileAsString(filePath);
        ScenarioDataStore.put(key, value);
        log.info("{}, {} variable stored", key, fileName);
    }

    @Step({"Store variable <key> = <value> during suite", "Suit boyunca değişkeni sakla <key> = <value>"})
    public void storeVariableDuringSuite(String key, String value) {
        SuiteDataStore.put(key, value);
        log.info("{}, {} variable stored", key, value);
    }

    @Step({"Store <file name>'s value from classpath with <key> during suite",
            "Suite boyunca <dosya adı> içeriğini <anahtarı ile sakla.>"})
    public void storeVariableDuringSuiteFromFile(String key, String fileName) {
        FileHelper fileHelper = new FileHelper();
        String filePath = getClass().getClassLoader().getResource(fileName).getPath();
        String value = fileHelper.readFileAsString(filePath);
        SuiteDataStore.put(key, value);
        log.info("{}, {} variable stored", key, fileName);
    }

    @Step({"Store variable <key> = <value> during spec", "Spec boyunca değişkeni sakla <key> = <value>"})
    public void storeVariableDuringSpec(String key, String value) {
        SpecDataStore.put(key, value);
        log.info("{}, {} variable stored", key, value);
    }

    @Step({"Store <file name>'s value from classpath with <key> during spec",
            "Spec boyunca <dosya adı> içeriğini <anahtarı ile sakla.>"})
    public void storeVariableDuringSpecFromFile(String key, String fileName) {
        FileHelper fileHelper = new FileHelper();
        String filePath = getClass().getClassLoader().getResource(fileName).getPath();
        String value = fileHelper.readFileAsString(filePath);
        SpecDataStore.put(key, value);
        log.info("{}, {} variable stored", key, fileName);
    }

    @Step("Remove <key> from store")
    public void removeFromStore(String key) {
        SpecDataStore.remove(key);
        log.info("{} romeved from store", key);
    }

    @Step({"Store table as map during scenario with <key> <table>",
            "Tabloyu map objesi olarak <key> anahtarı ile senaryo boyunca sakla <table>"})
    public void storeTable(String key, Table table) {
        Utils utils = new Utils();
        HashMap<String, Object> storeData = utils.gaugeDataTableToMap(table);
        ScenarioDataStore.put(key, storeData);
    }
}
