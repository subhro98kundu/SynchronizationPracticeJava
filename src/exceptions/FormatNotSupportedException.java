package exceptions;

public class FormatNotSupportedException extends RuntimeException {
    public FormatNotSupportedException(String message){
        super(message);
    }
}
