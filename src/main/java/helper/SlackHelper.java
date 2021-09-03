package helper;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterSpec;
import com.thoughtworks.gauge.BeforeSpec;
import com.thoughtworks.gauge.ExecutionContext;
import exceptions.RequestNotDefined;
import helper.methods.PostHelper;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SlackHelper {
    public static String webHook;
    private static Integer passCount = 0;
    private static Integer failCount = 0;
    private static Integer executed = 0;
    private static List<String> failedScenarios = new ArrayList<>();
    private static String startDate;

    private final Logger log = LogManager.getLogger(SlackHelper.class);

    @BeforeSpec
    public void beforeSpec() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        startDate = dtf.format(now);
    }

    @AfterSpec
    public void sendSlackMessage() {
        if (webHook != null) {
            RestAssured.baseURI = webHook;
            JSONObject body = new JSONObject();
            JSONArray attachments = new JSONArray();
            String message = "*Test Start:* " + startDate + "\n" +
                    "*" + executed + "* executed,  " +
                    "*" + passCount + "* passed, " +
                    "*" + failCount + "* failed";
            if (failedScenarios.size() > 0) {

                message = message + "\n *Failed scenarios is below:* \n";
                for (String name : failedScenarios) {
                    attachments.put(new JSONObject().put("text", name));
                }
            }

            body.put("text", message);
            body.put("attachments", attachments);

            sendMessageToSlackWebHook(body);

        }
    }

    @AfterScenario
    public void countFailAndPass(ExecutionContext context) {
        executed++;
        if (context.getCurrentScenario().getIsFailing()) {
            failCount++;
            failedScenarios.add(":heavy_multiplication_x: " + context.getCurrentScenario().getName() + "\n");
        } else
            passCount++;
    }

    private void sendMessageToSlackWebHook(Object body) {
        try {

            ApiHelper api = new ApiHelper();
            RequestBodyHelper payload = new RequestBodyHelper();
            HeaderHelper header = new HeaderHelper();
            FilterHelper filter = new FilterHelper();
            RequestUrlHelper url = new RequestUrlHelper();
            PostHelper post = new PostHelper();

            api.defineNewRequest();
            filter.addCustomLogFilter(400, 415, 500);
            header.addHeader("Content-type", "application/json");
            url.addBaseUrl(webHook);
            payload.addBody(body.toString());
            post.postRequest();

        } catch (RequestNotDefined e) {
            log.warn("Slack notification couldn't send");
        }
    }

}
