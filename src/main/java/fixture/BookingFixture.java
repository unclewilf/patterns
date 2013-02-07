package fixture;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class BookingFixture {

    private int intId = 0;

    public int nextIntId() {
        return intId++;
    }

    public String nextStringId() {
        return Integer.toString(intId++);
    }

    LinkedHashMap<Object, Object> objects = new LinkedHashMap<Object, Object>();

    List<BookingBuilder> builders = new ArrayList<BookingBuilder>();

    public <T extends Object> T storeObject(Object key, T newObject) {
        objects.put(key, newObject);
        return newObject;
    }

    private <T extends BookingBuilder> T storeBuilder(T builder) {
        builders.add(builder);
        return builder;
    }

    private BookingBuilder findBuilder(Object id) {
        for (BookingBuilder b : builders) {
            if (id.equals(b.getId())) {
                return b;
            }
        }
        return null;
    }

    public VerifyCheckinResponseBuilder verifyCheckinResponse() {
        return storeBuilder(new VerifyCheckinResponseBuilder(this));
    }

    public VerifyCheckinResponseBuilder verifyCheckinResponse(String id) {
        return verifyCheckinResponse().identifiedBy(id);
    }

    public VerifyCheckInResponse getVerifyCheckInResponse(String id) {
        return (VerifyCheckInResponse)objects.get(id);
    }

    public LeadPassengerBuilder leadPasseger() {
        return storeBuilder(new LeadPassengerBuilder(this));
    }

    public LeadPassengerBuilder leadPassenger(String pid) {
        return leadPasseger().identifiedBy(pid);
    }

    public LeadPassenger getLeadPassenger(String pid) {
        return (LeadPassenger)objects.get(pid);
    }

    public BookingFixture build() {
        while (!builders.isEmpty()) {
            builders.remove(0).build();
        }
        return this;
    }

}
