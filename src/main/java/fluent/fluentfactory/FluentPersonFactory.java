package fluent.fluentfactory;

import com.google.common.base.Strings;

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

    public FluentPersonFactory firstName(String firstName) {
        person.setFirstName(firstName);
        return this;
    }

    public FluentPersonFactory lastName(String lastName) {
        person.setLastName(lastName);
        return this;
    }

    public FluentPersonFactory age(int age) {
        person.setAge(age);
        return this;
    }

    public FluentPersonFactory active() {
        person.setActive(true);
        return this;
    }

    public FluentPersonFactory inactive() {
        person.setActive(false);
        return this;
    }

    public Person create() throws CreatePersonException {
        validate();
        return person;
    }

    private void validate() {
        Collection<String> missingParameters = new ArrayList<String>();
        if (Strings.isNullOrEmpty(person.getFirstName())) {
            missingParameters.add("first name");
        }
        if (Strings.isNullOrEmpty(person.getLastName())) {
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
