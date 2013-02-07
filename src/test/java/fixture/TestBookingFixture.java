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
            verifyCheckinResponse("PNR_1234").and(leadPasseger().withEmail("test@test.com"));
        }}.build();

        VerifyCheckInResponse verifyCheckInResponse = fixture.getVerifyCheckInResponse("PNR_1234");
        assertEquals("test@test.com", verifyCheckInResponse.getLeadPassenger().getEmail());
    }

}
