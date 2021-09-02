package exceptions;

public class RequestNotDefined extends Exception {
    public RequestNotDefined() {
        super("Bu metotu çağırabilmek için, lütfen önce defineNewRequest() methodu ile bir request oluşturun. ");
    }
}
