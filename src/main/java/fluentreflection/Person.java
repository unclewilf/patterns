package fluentreflection;

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

    public Integer getAge() {
        return age;
    }

}