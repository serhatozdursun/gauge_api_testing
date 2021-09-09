package exceptions;

public class NullValue extends Exception {

    final String  message;

    public NullValue(String selector) {

        this.message = "The selector you sent does not have any value. Selector :" + selector;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
