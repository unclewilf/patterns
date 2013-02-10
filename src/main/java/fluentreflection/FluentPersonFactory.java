package fluentreflection;

import com.google.common.base.Strings;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

public class FluentPersonFactory {

    private final Person person;

    private FluentPersonFactory() {
        this.person = new Person();
    }

    public static FluentPersonFactory person() {
        return new FluentPersonFactory();
    }

    private void setField(String fieldName, Object newValue) {
        try {
            Field field = person.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(person, newValue);
        } catch (Exception e) {
            System.out.println("No workie!");
        }
    }

    private String getField(String fieldName) {
        try {
            Field field = person.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return (String) field.get(person);
        } catch (Exception e) {
            return null;
        }
    }

    public FluentPersonFactory firstName(String firstName) {
        setField("firstName", firstName);
        return this;
    }

    public FluentPersonFactory lastName(String lastName) {
        setField("lastName", lastName);
        return this;
    }

    public FluentPersonFactory age(int age) {
        setField("age", age);
        return this;
    }

    public FluentPersonFactory active() {
        setField("isActive", true);
        return this;
    }

    public FluentPersonFactory inactive() {
        setField("isActive", false);
        return this;
    }

    public Person create() throws CreatePersonException {
        validate();
        return person;
    }

    private void validate() {
        Collection<String> missingParameters = new ArrayList<String>();
        if (Strings.isNullOrEmpty(getField("firstName"))) {
            missingParameters.add("first name");
        }
        if (Strings.isNullOrEmpty(getField("lastName"))) {
            missingParameters.add("last name");
        }
        if (person.getAge() == null) {
            missingParameters.add("age");
        }
        if (!missingParameters.isEmpty()) {
            throw new CreatePersonException(missingParameters);
        }
    }

}
