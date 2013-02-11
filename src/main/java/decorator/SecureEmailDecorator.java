package decorator;

public class SecureEmailDecorator extends EmailDecorator
{
    private String content;

    public SecureEmailDecorator(Email basicEmail) {
        originalEmail = basicEmail;
    }

    @Override
    public String getContents() {
        content = encrypt(originalEmail.getContents());
        return content;
    }

    private String encrypt(String message) {
        return message + " Secure";
    }

}
