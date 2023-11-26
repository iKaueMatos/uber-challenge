package uber.uber.Core.Exception;

import com.amazonaws.AmazonServiceException;

public class EmailServiceException extends RuntimeException {
    
    public EmailServiceException(String message, AmazonServiceException exception) {
        super(message);
    }
}
