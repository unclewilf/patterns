package fluent;

public class Person
{
    private String firstName;
    private String lastName;
    private Integer age;
    private boolean isActive;

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public boolean isActive() {
        return isActive;
    }

    protected Integer getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    protected void setLastName(String lastName) {
        this.lastName = lastName;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    protected void setActive(boolean active) {
        isActive = active;
    }

}