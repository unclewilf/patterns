package adapter;

import javax.servlet.ServletRequest;

public class HttpRequestForm implements Form {

    private ServletRequest request;

    public HttpRequestForm(ServletRequest request) {
        this.request = request;
    }

    @Override
    public String getCountry() {
        return (String) request.getAttribute(Form.COUNTRY);
    }

    @Override
    public Validation getValidation() {
        return new FormValidation(this, new FormErrorMessages(request));
    }

}
