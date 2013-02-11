package fluentreflection;

public class Person {

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

    public Integer isAged() {
        return age;
    }

}