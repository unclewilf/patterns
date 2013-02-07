package fixture;

public class VerifyCheckinResponseBuilder extends BookingBuilder<VerifyCheckInResponse> {

    private VerifyCheckInResponse verifyCheckInResponse;
    private String pnr;
    private LeadPassengerBuilder leadPassengerBuilder;

    public VerifyCheckinResponseBuilder(BookingFixture fixture) {
        super(fixture);
        this.pnr = fixture.nextStringId();
    }

    public VerifyCheckinResponseBuilder identifiedBy(String pnr) {
        this.pnr = pnr;
        return this;
    }

    public VerifyCheckinResponseBuilder and(LeadPassengerBuilder leadPassengerBuilder) {
        this.leadPassengerBuilder = leadPassengerBuilder;
        return this;
    }

    @Override
    public VerifyCheckInResponse build() {
        if (verifyCheckInResponse == null) {
            verifyCheckInResponse = new VerifyCheckInResponse();
            if (leadPassengerBuilder != null) {
                verifyCheckInResponse.setLeadPassenger(leadPassengerBuilder.build());
            }

            fixture.storeObject(pnr, verifyCheckInResponse);
        }
        return verifyCheckInResponse;
    }

}
