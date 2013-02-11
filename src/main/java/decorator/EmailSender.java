package decorator;

public class EmailSender {

    public String sendEmail(Email email) {
        ExternalEmailDecorator external = new ExternalEmailDecorator(email);
        return external.getContents();
    }

    public String sendSecureEmail(Email email) {
        SecureEmailDecorator external = new SecureEmailDecorator(email);
        return external.getContents();
    }

}
