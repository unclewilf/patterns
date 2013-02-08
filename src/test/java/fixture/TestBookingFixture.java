package fixture;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestBookingFixture {

    @Test
    public void createBooking() throws Exception {
        BookingFixture fixture = new BookingFixture() {{
            LeadPassengerBuilder leadPassenger = leadPasseger().withContactNumber("1234");

            verifyCheckinResponse("PNR_1234").and(leadPasseger().withEmail("test@test.com"));
            verifyCheckinResponse("PNR_5678").and(leadPassenger);
        }}.build();

        VerifyCheckInResponse verifyCheckInResponse1 = fixture.getVerifyCheckInResponse("PNR_1234");
        VerifyCheckInResponse verifyCheckInResponse2 = fixture.getVerifyCheckInResponse("PNR_5678");

        assertEquals("test@test.com", verifyCheckInResponse1.getLeadPassenger().getEmail());
        assertEquals("1234", verifyCheckInResponse2.getLeadPassenger().getContactNumber());
    }

}
