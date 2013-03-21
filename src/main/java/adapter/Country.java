package adapter;

import java.util.Map;

public class Country {

    public static final String COUNTRY_REGEX = "^[a-z]*$";

    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryRegex() {
        return COUNTRY_REGEX;
    }

    public Map<String, String> isValidForPaymentDetails() {
        return null;
    }

}
