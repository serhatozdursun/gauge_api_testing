package imp;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.ScenarioDataStore;
import com.thoughtworks.gauge.datastore.SpecDataStore;
import com.thoughtworks.gauge.datastore.SuiteDataStore;
import exceptions.NullResponse;
import exceptions.NullValue;
import exceptions.WrongFormatException;
import helper.ResponseBodyHelper;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.*;


public class CompareImp {

    @Step("Get <key1> and <key> from scenario store and then compare, Are they equals?")
    public void dataCompareEquals(String key1, String key2) throws WrongFormatException {
        Object value1 = ScenarioDataStore.get(key1);
        Object value2 = ScenarioDataStore.get(key2);
        Utils utils = new Utils();
        value2 = utils.parsSameType(value1,value2);
        assertEquals(value1, value2, "They aren't equals");
    }

    @Step("Get <key1> and <key> from spec store and then compare, Are they equals?")
    public void dataCompareEqualsFromSpecStore(String key1, String key2) throws WrongFormatException {
        Object value1 = SpecDataStore.get(key1);
        Object value2 = SpecDataStore.get(key2);
        Utils utils = new Utils();
        value2 = utils.parsSameType(value1,value2);
        assertEquals(value1, value2, "They aren't equals");
    }

    @Step("Get <key1> and <key> from suit store and then compare, Are they equals?")
    public void dataCompareEqualsFromSuitStore(String key1, String key2) throws WrongFormatException {
        Object value1 = SuiteDataStore.get(key1);
        Object value2 = SuiteDataStore.get(key2);
        Utils utils = new Utils();
        value2 = utils.parsSameType(value1,value2);
        assertEquals(value1, value2, "They aren't equals");
    }

    @Step("Get <key1> and <key> from scenario store and then compare, Are they not equals?")
    public void dataCompareNotEquals(String key1, String key2) throws WrongFormatException {
        Object value1 = ScenarioDataStore.get(key1);
        Object value2 = ScenarioDataStore.get(key2);
        Utils utils = new Utils();
        value2 = utils.parsSameType(value1,value2);
        assertNotEquals(value1, value2, "They are equals");
    }
    @Step("Get <key1> and <key> from suit store and then compare, Are they not equals?")
    public void dataCompareNotEqualsFromSpecStore(String key1, String key2) throws WrongFormatException {
        Object value1 = SpecDataStore.get(key1);
        Object value2 = SpecDataStore.get(key2);
        Utils utils = new Utils();
        value2 = utils.parsSameType(value1,value2);
        assertNotEquals(value1, value2, "They are equals");
    }
    @Step("Get <key1> and <key> from spec store and then compare, Are they not equals?")
    public void dataCompareNotEqualsFromSuitStore(String key1, String key2) throws WrongFormatException {
        Object value1 = SuiteDataStore.get(key1);
        Object value2 = SuiteDataStore.get(key2);
        Utils utils = new Utils();
        value2 = utils.parsSameType(value1,value2);
        assertNotEquals(value1, value2, "They are equals");
    }

    @Step("Check if <value1> is contains <value2> as string  ")
    public void dataCompareContains(String value1, String value2) {
        assertTrue(value1.contains(value2), String.format("%s isn't contains %s as String", value1, value2));
    }

    @Step("Get <key1> from scenario store and then compare with <value>, Are they equals?")
    public void dataCompareEqualsDirectData(String key1, Object value) throws WrongFormatException {
        Object value1 = ScenarioDataStore.get(key1);
        Utils utils = new Utils();
        value = utils.parsSameType(value1,value);
        assertEquals(value1, value, "They aren't equals");
    }

    @Step("Get <key1> from scenario store and then compare with <value>, Are they equals?")
    public void dataCompareEqualsDirectDataFromSpecStore(String key1, Object value) throws WrongFormatException {
        Object value1 = SpecDataStore.get(key1);
        Utils utils = new Utils();
        value = utils.parsSameType(value1,value);
        assertEquals(value1, value, "They aren't equals");
    }

    @Step("Get <key1> from scenario store then compare with <value>, Are they not equals?")
    public void dataCompareNotEqualsDirectData(String key1, Object value) throws WrongFormatException {
        Object value1 = ScenarioDataStore.get(key1);
        Utils utils = new Utils();
        value = utils.parsSameType(value1,value);
        assertNotEquals(value1, value, "They are equals");
    }

    @Step("Get <key1> from spec store then compare with <value>, Are they not equals?")
    public void dataCompareNotEqualsDirectDataFromSpecStore(String key1, Object value) throws WrongFormatException {
        Object value1 = SpecDataStore.get(key1);
        Utils utils = new Utils();
        value = utils.parsSameType(value1,value);
        assertNotEquals(value1, value, "They are equals");
    }

    @Step("Get <key> from scenario store and check if it is contains <value> as string  ")
    public void dataCompareContainsDirectData(String key1, String value) {
        String value1 = String.valueOf(ScenarioDataStore.get(key1));
        assertTrue(value1.contains(value), String.format("%s isn't contains %s as String", value1, value));
    }

    @Step("Get <key> from spec store and check if it is contains <value> as string  ")
    public void dataCompareContainsDirectDataFromSpecStore(String key1, String value) {
        String value1 = String.valueOf(SpecDataStore.get(key1));
        assertTrue(value1.contains(value), String.format("%s isn't contains %s as String", value1, value));
    }

    @Step("Get <selector> from response and then compare with <value>, Are they equals?")
    public void dataCompareEqualsFromResponse(String selector, Object value) throws NullResponse, WrongFormatException, NullValue {
        ResponseBodyHelper responseBodyHelper = new ResponseBodyHelper();
        Object value2 = responseBodyHelper.getResponseElement(selector);
        Utils utils = new Utils();
        value = utils.parsSameType(value2,value);
        assertEquals(value2, value, "They aren't equals");
    }

    @Step("Get <selector> from response then compare with <value>, Are they not equals?")
    public void dataCompareNotEqualsFromResponse(String selector, Object value) throws NullResponse, WrongFormatException, NullValue {
        ResponseBodyHelper responseBodyHelper = new ResponseBodyHelper();
        Object value2 = responseBodyHelper.getResponseElement(selector);
        Utils utils = new Utils();
        value = utils.parsSameType(value2, value);
        assertNotEquals(value2, value, "They are equals");
    }

}
