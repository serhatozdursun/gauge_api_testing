package imp;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.ScenarioDataStore;
import com.thoughtworks.gauge.datastore.SpecDataStore;
import com.thoughtworks.gauge.datastore.SuiteDataStore;
import helper.RandomHelper;

public class RandomDataStore {

    @Step("Generate new phone number and store as <key> during scenario")
    public void generatePhoneNumberScenario(String key) {
        RandomHelper randomHelper = new RandomHelper();
        String phoneNumber = randomHelper.generateGsmNumber();
        ScenarioDataStore.put(key, phoneNumber);
    }

    @Step("Generate new phone number and store as <key> during suit")
    public void generatePhoneNumberSuit(String key) {
        RandomHelper randomHelper = new RandomHelper();
        String phoneNumber = randomHelper.generateGsmNumber();
        SuiteDataStore.put(key, phoneNumber);
    }

    @Step("Generate new phone number and store as <key> during spec")
    public void generatePhoneNumberSpec(String key) {
        RandomHelper randomHelper = new RandomHelper();
        String phoneNumber = randomHelper.generateGsmNumber();
        SpecDataStore.put(key, phoneNumber);
    }

    @Step("Generate new mail address and store as <key> during scenario")
    public void generateMailScenario(String key) {
        RandomHelper randomHelper = new RandomHelper();
        String phoneNumber = randomHelper.generateMail();
        ScenarioDataStore.put(key, phoneNumber);
    }

    @Step("Generate new mail and store as <key> during suit")
    public void generateMailSuit(String key) {
        RandomHelper randomHelper = new RandomHelper();
        String phoneNumber = randomHelper.generateMail();
        SuiteDataStore.put(key, phoneNumber);
    }

    @Step("Generate new phone number and store as <key> during spec")
    public void generateMailSpec(String key) {
        RandomHelper randomHelper = new RandomHelper();
        String phoneNumber = randomHelper.generateMail();
        SpecDataStore.put(key, phoneNumber);
    }
}
