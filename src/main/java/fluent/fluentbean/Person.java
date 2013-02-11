package fluent.fluentbean;

public class Person
{
    private String firstName;
    private String lastName;
    private Integer age;
    private boolean isActive;

    public String isNamed() {
        return firstName + " " + lastName;
    }

    public boolean isActive() {
        return isActive;
    }

    public int isAged() {
        return age;
    }

    public Person aged(int age) {
        this.age = age;
        return this;
    }

    protected String getFirstName() {
        return firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    public Person firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Person lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Person active() {
        this.isActive = true;
        return this;
    }

    public Person inActive() {
        this.isActive = false;
        return this;
    }

}