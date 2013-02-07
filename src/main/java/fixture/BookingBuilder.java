package fixture;

public abstract class BookingBuilder<T> {
    
    protected BookingFixture fixture;
    protected String id;

    public BookingBuilder(BookingFixture fixture) {
        this.fixture = fixture;
    }

    public Object getId() {
        return id;
    }

    public abstract T build();
    
}
