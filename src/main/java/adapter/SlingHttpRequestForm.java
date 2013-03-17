package adapter;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

public class SlingHttpRequestForm implements Form {

    private SlingHttpServletRequest request;

    public SlingHttpRequestForm(SlingHttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String getCountry() {
        return (String) request.getAttribute(Form.COUNTRY);
    }

    @Override
    public Validation getValidation() {
        return new FormValidation(this, new FormErrorMessages(getValueMap()));
    }

    private ValueMap getValueMap() {
        return request.getResource().adaptTo(ValueMap.class);
    }

}
