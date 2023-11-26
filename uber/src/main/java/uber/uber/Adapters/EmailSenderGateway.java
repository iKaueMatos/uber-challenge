package uber.uber.Adapters;

public interface EmailSenderGateway {
    void sendEmail(String to, String subject, String body);
}
