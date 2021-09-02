package enums;

public enum LocatorType {

    ID("id"),
    CSS_SELECTOR("cssSelector"),
    XPATH("xpath"),
    NAME("name"),
    CLASS_NAME("className"),
    LINK_TEXT("linkText"),
    PARTIAL_LINK_TEXT("partialLinkText"),
    TAG_NAME("tagName"),
    CONTAINS("contains");

    public final String locatorTypeText;

    LocatorType(String value) {
        this.locatorTypeText = value;
    }

    public String getText() {
        return locatorTypeText;
    }
}
