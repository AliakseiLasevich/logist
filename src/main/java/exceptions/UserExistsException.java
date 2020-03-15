package exceptions;

public class UserExistsException extends RuntimeException {

    public UserExistsException(String errorMessage) {
        super(errorMessage);
    }


    public UserExistsException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
