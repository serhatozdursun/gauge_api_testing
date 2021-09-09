package imp;

import com.thoughtworks.gauge.Step;
import helper.SlackHelper;

public class SlackImp extends SlackHelper {

    @Step("Send slack message to <webhook>")
    public void sendSlackMessage(String webHook) {
        setWebHook(webHook);
    }

    private synchronized static void setWebHook(String webHook) {
        SlackHelper.webHook = "";
        SlackHelper.webHook = webHook;
    }
}
