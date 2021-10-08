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

    private static final String ARE_N0T_EQUALS = "They aren't equals";
    private static final String EQUALS = "They are equals";
    private static final String CONTAINS = "%s isn't contains %s as String";

    @Step({"Get <key1> and <key> from scenario store and then compare, Are they equals?",
            "Key <key1> ve <key2>'i senaryo deposundan getir ve eşit olduklarını doğrula",
            "Get <key1> and <key2> from the scenario store and verify they are equal"})
    public void dataCompareEquals(String key1, String key2) throws WrongFormatException {
        Object value1 = ScenarioDataStore.get(key1);
        Object value2 = ScenarioDataStore.get(key2);
        Utils utils = new Utils();
        value2 = utils.parsSameType(value1, value2);
        assertEquals(value1, value2, ARE_N0T_EQUALS);
    }

    @Step({"Get <key1> and <key> from spec store and then compare, Are they equals?",
            "Key <key1> ve <key2>'i spec deposundan getir ve eşit olduklarını doğrula",
            "Get <key1> and <key2> from the spec store and verify they are equal"})
    public void dataCompareEqualsFromSpecStore(String key1, String key2) throws WrongFormatException {
        Object value1 = SpecDataStore.get(key1);
        Object value2 = SpecDataStore.get(key2);
        Utils utils = new Utils();
        value2 = utils.parsSameType(value1, value2);
        assertEquals(value1, value2, ARE_N0T_EQUALS);
    }

    @Step({"Get <key1> and <key> from suit store and then compare, Are they equals?",
            "Key <key1> ve <key2>'i  suit deposundan getir ve eşit olduklarını doğrula",
            "Get <key1> and <key2> from the suit store and verify they are equal"})
    public void dataCompareEqualsFromSuitStore(String key1, String key2) throws WrongFormatException {
        Object value1 = SuiteDataStore.get(key1);
        Object value2 = SuiteDataStore.get(key2);
        Utils utils = new Utils();
        value2 = utils.parsSameType(value1, value2);
        assertEquals(value1, value2, ARE_N0T_EQUALS);
    }

    @Step({"Get <key1> and <key> from scenario store and then compare, Are they not equals?",
            "Key <key1> ve <key2>'i senaryo deposundan getir ve eşit olmadıklarını doğrula",
            "Get <key1> and <key2> from the secnario store and verify they aren't equal"})
    public void dataCompareNotEquals(String key1, String key2) throws WrongFormatException {
        Object value1 = ScenarioDataStore.get(key1);
        Object value2 = ScenarioDataStore.get(key2);
        Utils utils = new Utils();
        value2 = utils.parsSameType(value1, value2);
        assertNotEquals(value1, value2, ARE_N0T_EQUALS);
    }

    @Step({"Get <key1> and <key> from spec store and then compare, Are they not equals?",
            "Key <key1> ve <key2>'i spec deposundan getir ve eşit olmadıklarını doğrula",
            "Get <key1> and <key2> from the spec store and verify they aren't equal"})
    public void dataCompareNotEqualsFromSpecStore(String key1, String key2) throws WrongFormatException {
        Object value1 = SpecDataStore.get(key1);
        Object value2 = SpecDataStore.get(key2);
        Utils utils = new Utils();
        value2 = utils.parsSameType(value1, value2);
        assertNotEquals(value1, value2, EQUALS);
    }

    @Step({"Get <key1> and <key> from suit store and then compare, Are they not equals?",
            "Key <key1> ve <key2>'i suit deposundan getir ve eşit olmadıklarını doğrula",
            "Get <key1> and <key2> from the suit store and verify they aren't equal"})
    public void dataCompareNotEqualsFromSuitStore(String key1, String key2) throws WrongFormatException {
        Object value1 = SuiteDataStore.get(key1);
        Object value2 = SuiteDataStore.get(key2);
        Utils utils = new Utils();
        value2 = utils.parsSameType(value1, value2);
        assertNotEquals(value1, value2, EQUALS);
    }

    @Step({"Check if <value1> is contains <value2> as string",
            "Verify <value1> is contains <value2> as string",
            "Değer <value1>'in değer2 <value2>'i içerdiğini doğrula"})
    public void dataCompareContains(String value1, String value2) {
        assertTrue(value1.contains(value2), String.format(CONTAINS, value1, value2));
    }

    @Step({"Get <key1> from scenario store and then compare with <value>, Are they equals?",
            "Get <key1> from scenario store and verify it is equal with <value>",
            "Senaryo deposundan <key1> alın ve değer:<value> ile eşit olduğunu doğrulayın"})
    public void dataCompareEqualsDirectData(String key1, Object value) throws WrongFormatException {
        Object value1 = ScenarioDataStore.get(key1);
        Utils utils = new Utils();
        value = utils.parsSameType(value1, value);
        assertEquals(value1, value, ARE_N0T_EQUALS);
    }

    @Step({"Get <key1> from spec store and then compare with <value>, Are they equals?",
            "Get <key1> from spec store and verify it is equal with <value>",
            "Spec deposundan <key1> alın ve değer:<value> ile eşit olduğunu doğrulayın"})
    public void dataCompareEqualsDirectDataFromSpecStore(String key1, Object value) throws WrongFormatException {
        Object value1 = SpecDataStore.get(key1);
        Utils utils = new Utils();
        value = utils.parsSameType(value1, value);
        assertEquals(value1, value, ARE_N0T_EQUALS);
    }

    @Step({"Get <key1> from scenario store then compare with <value>, Are they not equals?",
            "Get <key1> from scenario store and verify it's not equals with <value>",
            "Senaryo deposundan <key1> alın ve <value> ile eşit olmadığını doğrulayın"})
    public void dataCompareNotEqualsDirectData(String key1, Object value) throws WrongFormatException {
        Object value1 = ScenarioDataStore.get(key1);
        Utils utils = new Utils();
        value = utils.parsSameType(value1, value);
        assertNotEquals(value1, value, EQUALS);
    }

    @Step({"Get <key1> from spec store then compare with <value>, Are they not equals?",
            "Get <key1> from spec store and verify it's not equals with <value>",
            "Spec deposundan <key1> alın ve <value> ile eşit olmadığını doğrulayın"})
    public void dataCompareNotEqualsDirectDataFromSpecStore(String key1, Object value) throws WrongFormatException {
        Object value1 = SpecDataStore.get(key1);
        Utils utils = new Utils();
        value = utils.parsSameType(value1, value);
        assertNotEquals(value1, value, EQUALS);
    }

    @Step({"Get <key1> from suit store then compare with <value>, Are they not equals?",
            "Get <key1> from suit store and verify it's not equals with <value>",
            "Suit deposundan <key1> alın ve <value> ile eşit olmadığını doğrulayın"})
    public void dataCompareNotEqualsDirectDataFromSuitStore(String key1, Object value) throws WrongFormatException {
        Object value1 = SuiteDataStore.get(key1);
        Utils utils = new Utils();
        value = utils.parsSameType(value1, value);
        assertNotEquals(value1, value, EQUALS);
    }

    @Step({"Get <key> from scenario store and check if it is contains <value> as string",
            "Get <key> from scenario store and verify it is contains <value> as string",
            "Senaryo deposundan <anahtar> alın ve dize olarak <değer> içerdiğini doğrulayın"})
    public void dataCompareContainsDirectData(String key1, String value) {
        String value1 = String.valueOf(ScenarioDataStore.get(key1));
        assertTrue(value1.contains(value), String.format(CONTAINS, value1, value));
    }

    @Step({"Get <key> from spec store and check if it is contains <value> as string",
            "Get <key> from spec store and verify it is contains <value> as string",
            "Spec deposundan <anahtar> alın ve dize olarak <değer> içerdiğini doğrulayın"})
    public void dataCompareContainsDirectDataFromSpecStore(String key1, String value) {
        String value1 = String.valueOf(SpecDataStore.get(key1));
        assertTrue(value1.contains(value), String.format(CONTAINS, value1, value));
    }

    @Step({"Get <key> from suit store and check if it is contains <value> as string",
            "Get <key> from suit store and verify it is contains <value> as string",
            "Suit deposundan <anahtar> alın ve dize olarak <değer> içerdiğini doğrulayın"})
    public void dataCompareContainsDirectDataFromSuitStore(String key1, String value) {
        String value1 = String.valueOf(SuiteDataStore.get(key1));
        assertTrue(value1.contains(value), String.format(CONTAINS, value1, value));
    }

    @Step({"Get <selector> from response and then compare with <value>, Are they equals?",
            "Get value with <selector> from response and verify it is equal with <value>",
            "Yanıttan <selector> ile değer alın ve <value> ile eşit olduğunu doğrulayın"})
    public void dataCompareEqualsFromResponse(String selector, Object value) throws NullResponse, WrongFormatException, NullValue {
        ResponseBodyHelper responseBodyHelper = new ResponseBodyHelper();
        Object value2 = responseBodyHelper.getResponseElement(selector);
        Utils utils = new Utils();
        value = utils.parsSameType(value2, value);
        assertEquals(value, value2, EQUALS);
    }

    @Step({"Get <selector> from response and then compare with <value>, Are they not equals?",
            "Get value with <selector> from response and verify it isn't equal with <value>",
            "Yanıttan <selector> ile değer alın ve <value> ile eşit olmadığını doğrulayın"})
    public void dataCompareNotEqualsFromResponse(String selector, Object value) throws NullResponse, WrongFormatException, NullValue {
        ResponseBodyHelper responseBodyHelper = new ResponseBodyHelper();
        Object value2 = responseBodyHelper.getResponseElement(selector);
        Utils utils = new Utils();
        value = utils.parsSameType(value2, value);
        assertNotEquals(value2, value, EQUALS);
    }

}
