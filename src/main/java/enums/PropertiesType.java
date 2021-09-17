package enums;

public enum PropertiesType {

    SLACK_TOKEN("slack_token");

    public final String propertiesTypeText;

    PropertiesType(String value) {
        this.propertiesTypeText = value;
    }

    public String getText() {
        return propertiesTypeText;
    }
}