package aims.exception;
import java.lang.Exception;
public class PlayerException extends Exception {
    public PlayerException(){
        super("The error is undefined");
    }
    public PlayerException(String message){
        super(message);
    }
    public PlayerException(String message, Throwable cause){
        super(message, cause);
    }
    public PlayerException(Throwable cause){
        super(cause);
    }
}
