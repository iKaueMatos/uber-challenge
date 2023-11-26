package uber.uber.InfraSes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

import uber.uber.Adapters.EmailSenderGateway;
import uber.uber.Core.Exception.EmailServiceException;

@Service
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService sesClient;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService sesClient) {
        this.sesClient = sesClient;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
            .withSource("ikauedeveloper@gmail.com")
            .withDestination(new Destination().withToAddresses(to))
            .withMessage(
                new Message()
                .withSubject(new Content(subject))
                .withBody(new Body().withText(new Content(body))
            ));
        
        try {
            sesClient.sendEmail(request);
        }
        catch (AmazonServiceException exception) {
            throw new EmailServiceException("Failure while sending email", exception);
        }
    }
}
