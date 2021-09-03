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
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SlackHelper {
    public static String webHook;
    private static Integer passCount = 0;
    private static Integer failCount = 0;
    private static Integer executed = 0;
    private static String failedScenarios = "";
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
            String message = "*Test Start:* " + startDate + "\n" +
                    "*" + executed + "* executed,  " +
                    "*" + passCount + "* passed, " +
                    "*" + failCount + "* failed";
            if (failedScenarios != null) {
                message = message + "\n *Failed scenarios is below:* \n" + failedScenarios;
            }

            body.put("text", message);

            sendMessageToSlackWebHook(body);

        }
    }

    @AfterScenario
    public void countFailAndPass(ExecutionContext context) {
        executed++;
        if (context.getCurrentScenario().getIsFailing()) {
            failCount++;
            failedScenarios += ":x: " + context.getCurrentScenario().getName() + "\n";
        } else
            passCount++;
    }

    private void sendMessageToSlackWebHook(Object body) {
        try {
            ApiHelper api = new ApiHelper();
            api.defineNewRequest();
            HeaderHelper header = new HeaderHelper();
            FilterHelper filter = new FilterHelper();
            filter.addCustomLogFilter(400, 415, 500);
            header.addHeader("Content-type", "application/json");
            RequestUrlHelper url = new RequestUrlHelper();
            url.addBaseUrl(webHook);
            RequestBodyHelper payload = new RequestBodyHelper();
            payload.addBody(body.toString());
            PostHelper post = new PostHelper();
            post.postRequest();
        } catch (RequestNotDefined e) {
            log.warn("Slack notification couldn't send");
        }
    }

}
