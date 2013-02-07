package fixture;

public class LeadPassengerBuilder extends BookingBuilder<LeadPassenger> {

    private LeadPassenger leadPassenger;
    private String uniqueId;
    private String email;
    private String contactNumber;

    public LeadPassengerBuilder(BookingFixture fixture) {
        super(fixture);
        this.uniqueId = fixture.nextStringId();
    }

    public LeadPassengerBuilder identifiedBy(String id) {
        this.uniqueId = id;
        return this;
    }

    public LeadPassengerBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public LeadPassengerBuilder withContactNumber(String number) {
        this.contactNumber = number;
        return this;
    }

    @Override
    public LeadPassenger build() {
        if (leadPassenger == null) {
            leadPassenger = new LeadPassenger();
            leadPassenger.setEmail(email);
            leadPassenger.setContactNumber(contactNumber);
            fixture.storeObject(uniqueId, leadPassenger);
        }
        return leadPassenger;
    }

}
