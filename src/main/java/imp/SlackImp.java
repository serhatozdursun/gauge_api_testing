package imp;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.SpecDataStore;
import configuration.Configuration;
import helper.SlackHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SlackImp extends SlackHelper {

    Logger log = LogManager.getLogger(SlackImp.class);

    @Step("Send test result as slack message to webhook <webhook>")
    public void sendSlackMessage(String webHook) {
        SpecDataStore.put("webHook", webHook);
    }

    @Step("Send test result as slack message to <channel_id>")
    public void sendSlackMessageWithToken(String channelId) {
        String token = Configuration.getInstance().getSlackToken();
        if (token != null && !token.equals("")) {
            SpecDataStore.put("channelId", channelId);
        } else
            log.warn("Token required for this step.");

    }

}
