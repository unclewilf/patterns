package adapter;

public interface Payment {

    String COUNTRY = "country";

    Validation getValidation();

    Country getCountry();
}
