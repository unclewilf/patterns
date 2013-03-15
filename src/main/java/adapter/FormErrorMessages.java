package adapter;

import javax.servlet.ServletRequest;

public class FormErrorMessages {

    private ServletRequest request;

    public FormErrorMessages(ServletRequest request) {
        this.request = request;
    }

    public String getRegexFailed() {
        return "";
    }
}
