package uber.uber.Core.UseCase;

public interface EmailSenderUseCase {
    public void sendEmail(String to, String subject, String body);
}
