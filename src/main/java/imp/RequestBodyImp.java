package imp;


import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import com.thoughtworks.gauge.datastore.ScenarioDataStore;
import com.thoughtworks.gauge.datastore.SpecDataStore;
import com.thoughtworks.gauge.datastore.SuiteDataStore;
import enums.RequestInfo;
import exceptions.NullResponse;
import exceptions.NullValue;
import exceptions.RequestNotDefined;
import helper.DocumentHelper;
import helper.FileHelper;
import helper.RequestBodyHelper;
import helper.ResponseBodyHelper;
import io.cucumber.java.en.Given;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import utils.StoreApiInfo;
import utils.Utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static enums.RequestInfo.REQUEST;
import static enums.RequestInfo.RESPONSE;

public class RequestBodyImp extends RequestBodyHelper {

    private final Logger log = LogManager.getLogger(RequestBodyImp.class);

    @Step({"Add payload as String from resource <file name>",
            "Add body as String from resource <file name>",
            "Dosyayadan String tipinde istek body'si ekle <dosya adı>"})
    @Given("Add payload as String from resource {string}")
    public void addBodyAsString(String fileName) throws RequestNotDefined {
        FileHelper fileHelper = new FileHelper();
        String filePath = Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).getPath();
        String payLoad = fileHelper.readFileAsString(filePath);
        addBody(payLoad);
    }

    @Step({"Add payload as file from resource <file name>",
            "Add body as file from resource <file name>",
            "Dosya tipinde istek body'si ekle <dosya adı>"})
    @Given("payload as file {string} from resource")
    public void addBodyAsFile(String fileName) throws RequestNotDefined {
        String filePath = Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).getPath();

        File file = new File(filePath);
        addBody(file);
    }

    @Step({"Add payload as map <table>",
            "Add body as map <table>",
            "Tablodan istek body'si ekle <table>"})
    public void addBodyAsFile(Table table) throws RequestNotDefined {
        List<TableRow> rows = table.getTableRows();
        HashMap<Object, Object> body = new HashMap<>();
        for (TableRow row : rows) {
            body.put(row.getCellValues().get(0), row.getCellValues().get(1));
        }
        addBody(body);
    }

    @Given("Add payload as map")
    public void addBodyAsFile(Map<String,Object> body) throws RequestNotDefined {
        addBody(body);
    }

    @Step({"Add payload from scenario store with <key>",
            "Add body from scenario store with <key>",
            "Senaryo kayıtlı verisinden istek body'si ekle, kayıt anahtarı <key>"})
    @Given("Add payload from scenario store with {string}")
    public void addBodyFromScenarioStore(String key) throws RequestNotDefined {
        addBody(ScenarioDataStore.get(key));
    }

    @Step({"Add payload from suite store with <key>",
            "Add body from suite store with <key>",
            "Suit kayıtlı verisinden istek body'si ekle, kayıt anahtarı <key>"})
    @Given("Add payload from suit store with {string}")
    public void addBodyFromScenarioSuite(String key) throws RequestNotDefined {
        addBody(SuiteDataStore.get(key));
    }

    @Step({"Add payload from spec store with <key>",
            "Add body from spec store with <key>",
            "Spec kayıtlı verisinden istek body'si ekle, kayıt anahtarı <key>"})
    @Given("Add payload from spec store with {string}")
    public void addBodyFromScenarioSpec(String key) throws RequestNotDefined {
        addBody(SpecDataStore.get(key));
    }

    @Step({"Get body with <key> from store and update <selector> as <key1> from scenario data",
            "<key> anahtarı ile saklanan body'den, <selector> değerini al, kayıtlı <key1>'in değeri ile güncelle"})
    @Given("Get body with {string} key from store and update {string} json selector as {string} key from scenario data")
    public void updateBodyFromScenarioData(String key, String selector, String key1) {
        DocumentHelper documentHelper = new DocumentHelper();
        String body = String.valueOf(Utils.getFromStoreData(key));
        String newValue = String.valueOf(ScenarioDataStore.get(key1));
        newValue = newValue.equalsIgnoreCase("null") ? null : newValue;
        Object newBody = documentHelper.updateDocument(body, selector, newValue);
        ScenarioDataStore.put(key, newBody);
        log.info("\"{}\" is update as \"{}\" from \"{}\" in scenario store", selector, newValue, key);
    }

    @Step({"Update <selector>=<value> json from stored scenario with key <key>"})
    @Given("Get json from store and update {string} selector = {string} then store it same key {string}")
    public void updateBody(String selector, String newValue, String key) {
        DocumentHelper documentHelper = new DocumentHelper();
        String body = String.valueOf(Utils.getFromStoreData(key));
        newValue = newValue.equalsIgnoreCase("null") ? null : newValue;

        Object newBody = documentHelper.updateDocument(body, selector, newValue);
        ScenarioDataStore.put(key, newBody);
        log.info("\"{}\" is update as \"{}\" from \"{}\" in scenario store", selector, newValue, key);
    }

    @Step({"Get json file <file> and update as <selector>=<new> then add request",
            "Resource'dan json dosyasını <filename> oku ve <selector>=<value> olarak güncele sonra requeste ekle "})
    @Given("Get json file {string} from classpath and update as {string}={string} then add request")
    public void updateAndAdd(String fileName, String selector, String newValue) throws RequestNotDefined {
        DocumentHelper documentHelper = new DocumentHelper();
        FileHelper fileHelper = new FileHelper();
        var filePath =Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).getPath();

        var body = fileHelper.readFileAsString(filePath);
        newValue = newValue.equalsIgnoreCase("null") ? null : newValue;
        Object newBody = documentHelper.updateDocument(body, selector, newValue);
        addBody(newBody);
    }
}
