package imp;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.ScenarioDataStore;
import com.thoughtworks.gauge.datastore.SpecDataStore;
import com.thoughtworks.gauge.datastore.SuiteDataStore;
import exceptions.NullResponse;
import exceptions.NullValue;
import helper.ResponseBodyHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ResponseBodyImp extends ResponseBodyHelper {

    private final Logger log = LogManager.getLogger(ResponseBodyImp.class);

    @Step({"Store response as string with <key> during scenario",
            "Response'u String olarak <key> anahtarı ile senaryo boyunca sakla."})
    public void storeResponseForScenario(String key) throws NullResponse {
        ScenarioDataStore.put(key, getResponseAsString());
        log.info("response stored with key \"{}\" during scenario", key);
    }

    @Step({"Store response as string with <key> during suite",
            "Response'u String olarak <key> anahtarı ile suite boyunca sakla."})
    public void storeResponseForSuite(String key) throws NullResponse {
        SuiteDataStore.put(key, getResponseAsString());
        log.info("response stored with key \"{}\" during suite", key);
    }

    @Step({"Store response as string with <key> during spec",
            "Response'u String olarak <key> anahtarı ile spec boyunca sakla."})
    public void storeResponseForSpece(String key) throws NullResponse {
        SuiteDataStore.put(key, getResponseAsString());
        log.info("response stored with key \"{}\" during spec", key);
    }

    @Step({"Get <selector> from response and store it with <key> during scenario",
            "Respons'dan <selector> değerini getir ve <key> anahtarı ile senaryo boyunca sakla"})
    public void getResponseElementValueForScenario(String selector, String key) throws NullResponse, NullValue {
        Object value = getResponseElement(selector);
        ScenarioDataStore.put(key, value);
        log.info("\"{}\" is stored with \"{}\" during scenario", selector, key);
    }

    @Step({"Get <selector> from response and store it with <key> during suite",
            "Respons'dan <selector> değerini getir ve <key> anahtarı ile suite boyunca sakla"})
    public void getResponseElementValueForSuite(String selector, String key) throws NullResponse, NullValue {
        Object value = getResponseElement(selector);
        SuiteDataStore.put(key, value);
        log.info("\"{}\" is stored with \"{}\" during suite", selector, key);
    }

    @Step({"Get <selector> from response and store it with <key> during spec",
            "Respons'dan <selector> değerini getir ve <key> anahtarı ile spec boyunca sakla"})
    public void getResponseElementValueForSpec(String selector, String key) throws NullResponse, NullValue {
        Object value = getResponseElement(selector);
        SpecDataStore.put(key, value);
        log.info("\"{}\" is stored with {} during spec", selector, key);
    }


}
