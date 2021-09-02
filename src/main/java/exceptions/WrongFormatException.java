package exceptions;

public class WrongFormatException extends Exception {
    String message;

    public WrongFormatException(Object firstElmType, Object secondElmType) {
        String f_Type = firstElmType.getClass().getSimpleName();
        String s_Type = secondElmType.getClass().getSimpleName();
        this.message = "The objects which is trying to compare arent same type" +
                "" + firstElmType + "'s type ise " + f_Type + " " +
                "" + secondElmType + "'s type ise " + s_Type + " " +
                " They cant be compare";
    }

    @Override
    public String getMessage() {
        return message;
    }

}
