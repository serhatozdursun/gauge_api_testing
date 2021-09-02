package imp;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.ScenarioDataStore;
import com.thoughtworks.gauge.datastore.SpecDataStore;
import com.thoughtworks.gauge.datastore.SuiteDataStore;
import exceptions.NullResponse;
import helper.JsonSchemaHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JsonSchemaImp extends JsonSchemaHelper {

    private final Logger log = LogManager.getLogger(JsonSchemaImp.class);

    @Step("Validate response json with schema <Schema Name>")
    public void validateJsonSchema(String schemaName) throws NullResponse {
        try {
            jsonSchemaValidatior(schemaName);
            log.info("response validate with {} json schema", schemaName);
        } catch (Exception e) {
            log.error("An error occurred; {}", e.getMessage());
            throw e;
        }
    }

    @Step("Validate stored json <json store key> response with stored schema <schema store key> from scenario data store")
    public void validateJsonSchema(String jsonStoreKey, String schemaStoreKey) {
        try {
            String responseJsonString = String.valueOf(ScenarioDataStore.get(jsonStoreKey));
            String jsonSchema = String.valueOf(ScenarioDataStore.get(schemaStoreKey));
            jsonSchemaValidatior(responseJsonString, jsonSchema);
            log.info("{} json validate with {} schema", jsonStoreKey, schemaStoreKey);
        } catch (Exception e) {
            log.error("An error occurred; {}", e.getMessage());
            throw e;
        }
    }

    @Step("Validate json <store key> from the scenario stored data with schema <schema store key> in classpath")
    public void validateJsonSchemaInClasspathWithScenarioData(String jsonStoreKey, String schemaName) {
        try {
            String responseJsonString = String.valueOf(ScenarioDataStore.get(jsonStoreKey));
            jsonSchemaValidatiorInClasspath(responseJsonString, schemaName);
            log.info("{} json validate with {} schema", jsonStoreKey, schemaName);
        } catch (Exception e) {
            log.error("An error occurred; {}", e.getMessage());
            throw e;
        }
    }

    @Step("Validate json <store key> from the spec stored data with schema <schema store key> in classpath")
    public void validateJsonSchemaInClasspathWithSpecData(String jsonStoreKey, String schemaName) {
        try {
            String responseJsonString = String.valueOf(SpecDataStore.get(jsonStoreKey));
            jsonSchemaValidatiorInClasspath(responseJsonString, schemaName);
            log.info("{} json validate with {} schema", jsonStoreKey, schemaName);
        } catch (Exception e) {
            log.error("An error occurred; {}", e.getMessage());
            throw e;
        }
    }

    @Step("Validate json <store key> from the suit stored data with schema <schema store key> in classpath")
    public void validateJsonSchemaInClasspathWithSuitData(String jsonStoreKey, String schemaName) {
        try {
            String responseJsonString = String.valueOf(SuiteDataStore.get(jsonStoreKey));
            jsonSchemaValidatiorInClasspath(responseJsonString, schemaName);
            log.info("{} json validate with {} schema", jsonStoreKey, schemaName);
        } catch (Exception e) {
            log.error("An error occurred; {}", e.getMessage());
            throw e;
        }
    }

    @Step("Validate response with  schema <schema store key> in classpath according draft4")
    public void validateJsonSchemaInClasspathAccordingDraft4(String schemaName) throws NullResponse {
        try {
            jsonSchemaValidatiorWithDraft4(schemaName);
            log.info("response json validate with {} schema", schemaName);
        } catch (Exception e) {
            log.error("An error occurred; {}", e.getMessage());
            throw e;
        }
    }

    @Step("Validate response with  schema <schema store key> in classpath according draft3")
    public void validateJsonSchemaInClasspathAccordingDraft3(String schemaName) throws NullResponse {
        try {
            jsonSchemaValidatiorWithDraft3(schemaName);
            log.info("response json validate with {} schema", schemaName);
        } catch (Exception e) {
            log.error("An error occurred; {}", e.getMessage());
            throw e;
        }
    }

    @Step("Validate response with  schema <schema store key> in classpath according hyper schema")
    public void validateJsonSchemaInClasspathAccordingHyperSchema(String schemaName) throws NullResponse {
        try {
            jsonSchemaValidatiorWithHyperSchema(schemaName);
            log.info("response json validate with {} schema", schemaName);
        } catch (Exception e) {
            log.error("An error occurred; {}", e.getMessage());
            throw e;
        }
    }
}
