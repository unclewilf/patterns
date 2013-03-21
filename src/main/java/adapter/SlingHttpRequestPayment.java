package adapter;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

public class SlingHttpRequestPayment implements Payment {

    private SlingHttpServletRequest request;
    private Country country = new Country();

    public SlingHttpRequestPayment(SlingHttpServletRequest request) {
        this.request = request;
    }

    @Override
    public Country getCountry() {
        String countryString = (String) request.getAttribute(Payment.COUNTRY);
        country.setCountry(countryString);
        return country;
    }

    private ValueMap getValueMap() {
        return request.getResource().adaptTo(ValueMap.class);
    }

}
