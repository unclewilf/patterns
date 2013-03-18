package adapter;

import org.apache.sling.api.resource.ValueMap;

public class SlingFormErrorMessages implements FormErrorMessages {

    public static final String COUNTRY_REGEX_INVALID = "countryRegexInvalid";

    private ValueMap valueMap;

    public SlingFormErrorMessages(ValueMap valueMap) {
        this.valueMap = valueMap;
    }

    @Override
    public String getCountryRegexInvalid() {
        return valueMap.get(COUNTRY_REGEX_INVALID, String.class);
    }

}
