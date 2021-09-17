package helper;


import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.slack.api.model.Attachment;
import com.slack.api.model.Conversation;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterSpec;
import com.thoughtworks.gauge.BeforeSpec;
import com.thoughtworks.gauge.ExecutionContext;
import com.thoughtworks.gauge.datastore.SpecDataStore;
import configuration.Configuration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SlackHelper {

    private static Integer passCount = 0;
    private static Integer failCount = 0;
    private static Integer executed = 0;
    private static final List<String> failedScenarios = new ArrayList<>();
    private static String startDate;

    private final Logger log = LogManager.getLogger(SlackHelper.class);

    @BeforeSpec
    public void beforeSpec() {
        setStartDate();
    }

    @AfterSpec
    public void sendSlackMessage() {
        String webHook = String.valueOf(SpecDataStore.get("webHook"));
        String slackToken = Configuration.getInstance().getSlackToken();
        String channelId = String.valueOf(SpecDataStore.get("channelId"));
        if (webHook != null && !webHook.equals("") && !webHook.equals("null"))
            sendSlackMessageWithWebHook(webHook);
        else if (slackToken != null && !slackToken.equals("") && !slackToken.equals("null"))
            sendSlackMessageWithToken(slackToken, channelId);

    }

    @AfterScenario
    public void updateStatus(ExecutionContext context) {
        countPassFailAndExecuted(context);
    }

    private void sendMessageToSlackWebHook(Object body) {
        String webHook = String.valueOf(SpecDataStore.get("webHook"));
        Response response = RestAssured
                .given()
                .header("Content-type", "application/json")
                .baseUri(webHook)
                .body(body.toString())
                .post();
        if (response.statusCode() != 200) {
            log.warn("Slack message couldn't send, please check your webhook is active?");
        }
    }

    private static synchronized void setStartDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        startDate = dtf.format(now);
    }

    private static synchronized void countPassFailAndExecuted(ExecutionContext context) {
        executed++;
        boolean isFailed = context.getCurrentScenario().getIsFailing();
        if (isFailed) {
            failCount++;
            failedScenarios.add(":heavy_multiplication_x: " + context.getCurrentScenario().getName() + "\n");
        } else
            passCount++;
    }

    private void sendSlackMessageWithWebHook(String webHook) {
        if (webHook != null) {
            JSONObject body = new JSONObject();
            JSONArray attachments = new JSONArray();
            String message = createText();
            if (!failedScenarios.isEmpty()) {
                for (String name : failedScenarios) {
                    attachments.put(new JSONObject().put("text", name));
                }
            }

            body.put("text", message);
            body.put("attachments", attachments);

            sendMessageToSlackWebHook(body);

        }
    }

    private void sendSlackMessageWithToken(String token, String channelId) {
        var client = Slack.getInstance().methods();
        var id = findConversation(channelId, token);
        var text = createText();
        try {
            var result = client.chatPostMessage(r -> r
                    .token(token)
                    .channel(id)
                    .attachments(createAttachments())
                    .text(text));
            if (!result.isOk()) {
                log.warn("Slack message couldn't send, the message: {} ", result.getMessage());
            }

        } catch (IOException | SlackApiException e) {
            log.error("error: {}", e.getMessage(), e);
        }
    }

    private String findConversation(String name, String token) {
        // you can get this instance via ctx.client() in a Bolt app
        var client = Slack.getInstance().methods();
        String conversationId = null;
        try {
            // Call the conversations.list method using the built-in WebClient
            var result = client.conversationsList(r -> r
                    // The token you used to initialize your app
                    .token(token)
            );
            for (Conversation channel : result.getChannels()) {
                if (channel.getName().equals(name)) {
                    conversationId = channel.getId();
                    // Print result
                    log.info("Found conversation ID: {}", conversationId);
                    // Break from for loop
                    break;
                }
            }
        } catch (IOException | SlackApiException e) {
            log.error("error: {}", e.getMessage(), e);
        }
        return conversationId;
    }

    private String createText() {
        String message = "*Test Start:* " + startDate + "\n" +
                "*" + executed + "* executed,  " +
                "*" + passCount + "* passed, " +
                "*" + failCount + "* failed";
        if (!failedScenarios.isEmpty())
            message += "\n *Failed scenarios is below:* \n";

        return message;
    }

    private List<Attachment> createAttachments() {
        List<Attachment> attachments = new ArrayList<>();

        if (!failedScenarios.isEmpty()) {
            for (String name : failedScenarios) {
                Attachment attachment = new Attachment();
                attachment.setText(name);
                attachments.add(attachment);
            }
            return attachments;
        }
        return attachments;
    }
}
