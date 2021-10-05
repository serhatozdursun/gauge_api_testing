package imp;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.ScenarioDataStore;
import com.thoughtworks.gauge.datastore.SpecDataStore;
import com.thoughtworks.gauge.datastore.SuiteDataStore;
import helper.RandomHelper;

public class RandomDataStore extends RandomHelper {

    @Step("Generate new phone number and store as <key> during scenario")
    public void generatePhoneNumberScenario(String key) {
        String phoneNumber = generateGsmNumber();
        ScenarioDataStore.put(key, phoneNumber);
    }

    @Step("Generate new phone number and store as <key> during suit")
    public void generatePhoneNumberSuit(String key) {
        String phoneNumber = generateGsmNumber();
        SuiteDataStore.put(key, phoneNumber);
    }

    @Step("Generate new phone number and store as <key> during spec")
    public void generatePhoneNumberSpec(String key) {
        String phoneNumber = generateGsmNumber();
        SpecDataStore.put(key, phoneNumber);
    }

    @Step("Generate new mail address and store as <key> during scenario")
    public void generateMailScenario(String key) {
        String phoneNumber = generateMail();
        ScenarioDataStore.put(key, phoneNumber);
    }

    @Step("Generate new mail and store as <key> during suit")
    public void generateMailSuit(String key) {
        String phoneNumber = generateMail();
        SuiteDataStore.put(key, phoneNumber);
    }

    @Step("Generate new phone number and store as <key> during spec")
    public void generateMailSpec(String key) {
        String phoneNumber = generateMail();
        SpecDataStore.put(key, phoneNumber);
    }

    @Step({"Generate a <digit> digit number and store it in Scenario store as <> key",
            "Sayı oluştur, <basamakl> basamaklı ve senaryo deposuna <anahtar> anahtarı ile kaydet"})
    public void generateSpecificDigitNumberStoreScenario(int digit, String key) {
        ScenarioDataStore.put(key, generateNumberByNumberOfDigit(digit));
    }

    @Step({"Generate a <digit> digit number and store it in Spec store as <> key",
            "Sayı oluştur, <basamakl> basamaklı ve spec deposuna <anahtar> anahtarı ile kaydet"})
    public void generateSpecificDigitNumberStoreSpec(int digit, String key) {
        SpecDataStore.put(key, generateNumberByNumberOfDigit(digit));
    }

    @Step({"Generate a <digit> digit number and store it in Suit store as <> key",
            "Sayı oluştur, <basamakl> basamaklı ve suit deposuna <anahtar> anahtarı ile kaydet"})
    public void generateSpecificDigitNumberStoreSuit(int digit, String key) {
        SpecDataStore.put(key, generateNumberByNumberOfDigit(digit));
    }

    @Step({"Generate a max <max> digit number and store it in Suit store as <> key",
            "Sayı oluştur,en fazla <basamakl> basamaklı ve suit deposuna <anahtar> anahtarı ile kaydet"})
    public void generateNumberStoreSuit(int digit, String key) {
        SpecDataStore.put(key, generateNumber(digit));
    }

    @Step({"Generate a max <max> digit number and store it in Spec store as <> key",
            "Sayı oluştur,en fazla <basamakl> basamaklı ve spec deposuna <anahtar> anahtarı ile kaydet"})
    public void generateNumberStoreSpec(int digit, String key) {
        SpecDataStore.put(key, generateNumber(digit));
    }

    @Step({"Generate a max <max> digit number and store it in Scenario store as <> key",
            "Sayı oluştur,en fazla <basamakl> basamaklı ve senaryo deposuna <anahtar> anahtarı ile kaydet"})
    public void generateNumberStoreScenario(int digit, String key) {
        ScenarioDataStore.put(key, generateNumber(digit));
    }
}
