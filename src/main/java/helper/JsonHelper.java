package helper;


import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Utils;

import java.math.BigInteger;

import static com.jayway.jsonpath.JsonPath.read;
import static com.jayway.jsonpath.JsonPath.using;


public class JsonHelper {

    private final Logger log = LogManager.getLogger(JsonHelper.class);


    /**
     * it is convert the json string to jayway documentcontext.
     *
     * @param json is string json.
     * @return return is json string as documentcontext
     */
    public DocumentContext getJsonDocumentContext(String json) {
        Configuration configuration = Configuration.builder()
                .jsonProvider(new JacksonJsonNodeJsonProvider())
                .mappingProvider(new JacksonMappingProvider())
                .build();
        return using(configuration).parse(json);
    }

    /**
     * it find json object by json key and then update the json value according
     * the jsonobject type (String, int, bool, etc)
     *
     * @param json     is json as string
     * @param jsonKey  is specified pattern json key.
     * @param newValue is new value tu update
     * @return is the json string after update.
     */
    public String updateJsonValue(String json, String jsonKey, String newValue) {
        DocumentContext context = getJsonDocumentContext(json);
        ParseHelper parseHelper = new ParseHelper();
        try {
            Object o = read(json, jsonKey);
            String valueType = o.getClass().getSimpleName();

            switch (valueType) {
                case "Integer":
                    Integer integerValue = parseHelper.parsStringToInt(newValue);
                    if (integerValue != null)
                        context.set(jsonKey, integerValue);
                    break;
                case "BigInteger":
                    BigInteger bigInteger = parseHelper.parsStringToBigint(newValue);
                    if (bigInteger != null)
                        context.set(jsonKey, bigInteger);
                    break;
                case "Boolean":
                    Boolean boolValue = parseHelper.parseStringToBoolean(newValue);
                    if (boolValue != null)
                        context.set(jsonKey, boolValue);
                    break;
                case "Float":
                    Float floatValue = parseHelper.parsStringToFloat(newValue);
                    if (floatValue != null)
                        context.set(json, floatValue);
                    break;
                case "Double":
                    Double doubleValue = parseHelper.parsStringToDouble(newValue);
                    if (doubleValue != null)
                        context.set(jsonKey, doubleValue);
                    break;
                default:
                    context.set(jsonKey, newValue);
                    break;

            }
            return context.jsonString();
        } catch (PathNotFoundException je) {
            Utils utils = new Utils();
            log.warn("{} is couldn't find, json detail:\n" + utils.prettyPrint(json), jsonKey);
            return json;
        }
    }

}
