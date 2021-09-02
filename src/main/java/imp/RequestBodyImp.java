package imp;


import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import com.thoughtworks.gauge.datastore.ScenarioDataStore;
import com.thoughtworks.gauge.datastore.SpecDataStore;
import com.thoughtworks.gauge.datastore.SuiteDataStore;
import exceptions.NullResponse;
import exceptions.NullValue;
import exceptions.RequestNotDefined;
import helper.DocumentHelper;
import helper.FileHelper;
import helper.RequestBodyHelper;
import helper.ResponseBodyHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class RequestBodyImp extends RequestBodyHelper {

    private final Logger log = LogManager.getLogger(RequestBodyImp.class);

    @Step({"Add payload as String from resource <file name>", "Dosyayadan String tipinde istek body'si ekle <dosya adı>"})
    public void addBodyAsString(String fileName) throws RequestNotDefined {
        FileHelper fileHelper = new FileHelper();
        String filePath = "src/test/resources/"+fileName;
        String payLoad = fileHelper.readFileAsString(filePath);
        addBody(payLoad);
    }

    @Step({"Add payload as file from resource <file name>", "Dosya tipinde istek body'si ekle <dosya adı>"})
    public void addBodyAsFile(String fileName) throws RequestNotDefined {
        String filePath = "src/test/resources/"+fileName;
        File file = new File(filePath);
        addBody(file);
    }

    @Step({"Add payload as map <table>", "Tablodan istek body'si ekle <table>"})
    public void addBodyAsFile(Table table) throws RequestNotDefined {
        List<TableRow> rows = table.getTableRows();
        HashMap<Object, Object> body = new HashMap<>();
        for (TableRow row : rows) {
            body.put(row.getCellValues().get(0), row.getCellValues().get(1));
        }
        addBody(body);
    }

    @Step({"Add payload from scenario store with <key>",
            "Senaryo kayıtlı verisinden istek body'si ekle, kayıt anahtarı <key>"})
    public void addBodyFromScenarioStore(Object key) throws RequestNotDefined {
        addBody(ScenarioDataStore.get(key));
    }

    @Step({"Add payload from suite store with <key>",
            "Suit kayıtlı verisinden istek body'si ekle, kayıt anahtarı <key>"})
    public void addBodyFromScenarioSuite(Object key) throws RequestNotDefined {
        addBody(SuiteDataStore.get(key));
    }

    @Step({"Add payload from spec store with <key>",
            "Spec kayıtlı verisinden istek body'si ekle, kayıt anahtarı <key>"})
    public void addBodyFromScenarioSpec(Object key) throws RequestNotDefined {
        addBody(SpecDataStore.get(key));
    }

    @Step({"Get body with <key> from scenario data and update <selector> as <key1> from scenario data",
            "<key> anahtarı ile saklanan body'den, <selector> değerini al, kayıtlı <key1>'in değeri ile güncelle"})
    public void updateBodyFromScenarioData(String key, String selector, String key1) {
        DocumentHelper documentHelper = new DocumentHelper();
        String body = String.valueOf(ScenarioDataStore.get(key));
        String newValue = String.valueOf(ScenarioDataStore.get(key1));
        newValue = newValue.equalsIgnoreCase("null")?null:newValue;

        Object newBody = documentHelper.updateDocument(body, selector, newValue);
        ScenarioDataStore.put(key, newBody);
        log.info("\"{}\" is update as \"{}\" from \"{}\" in scenario store", selector, newValue, key);
    }

    @Step({"Update <selector>=<value> json from stored scenario with key <key>"})
    public void updateBody( String selector, String newValue,String key) {
        DocumentHelper documentHelper = new DocumentHelper();
        String body = String.valueOf(ScenarioDataStore.get(key));
        newValue = newValue.equalsIgnoreCase("null")?null:newValue;

        Object newBody = documentHelper.updateDocument(body, selector, newValue);
        ScenarioDataStore.put(key, newBody);
        log.info("\"{}\" is update as \"{}\" from \"{}\" in scenario store", selector, newValue, key);
    }

    @Step("Get <selector> from response and then check if is not null?")
    public void checkDataFromResponseIsNotNull(String selector) throws NullResponse, NullValue {
        ResponseBodyHelper responseBodyHelper = new ResponseBodyHelper();
        Object value2 = responseBodyHelper.getResponseElementEvenNull(selector);
        Assertions.assertNotNull(value2, selector + " is null");
    }

    @Step("Get <selector> from response and then check if is null?")
    public void checkDataFromResponseIsNull(String selector) throws NullResponse, NullValue {
        ResponseBodyHelper responseBodyHelper = new ResponseBodyHelper();
        Object value2 = responseBodyHelper.getResponseElementEvenNull(selector);
        Assertions.assertNull(value2,selector+" is not null");
    }
}
