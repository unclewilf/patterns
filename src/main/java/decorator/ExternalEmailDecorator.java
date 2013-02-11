package decorator;

public class ExternalEmailDecorator extends EmailDecorator {
    private String content;

    public ExternalEmailDecorator(Email basicEmail) {
        originalEmail = basicEmail;
    }

    @Override
    public String getContents() {
        content = addDisclaimer(originalEmail.getContents());
        return content;
    }

    private String addDisclaimer(String message) {
        return  message + " Company Disclaimer";
    }

}
