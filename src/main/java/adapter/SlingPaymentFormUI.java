package adapter;

import org.apache.sling.api.resource.ValueMap;

public class SlingPaymentFormUI implements PaymentFormUI {

    private ValueMap valueMap;
    private FormErrorMessages errorMessages;

    private Country country = new Country();

    public SlingPaymentFormUI(ValueMap valueMap, FormErrorMessages errorMessages) {
        this.valueMap = valueMap;
        this.errorMessages = errorMessages;
    }

    @Override
    public String getCountryLabel() {
        return valueMap.get(COUNTRY_LABEL, String.class);
    }

    @Override
    public String getCountryRegex() {
        return country.getCountryRegex();
    }

    public String getCountryRegexMessage() {
        return errorMessages.getCountryRegexInvalid();
    }

}
