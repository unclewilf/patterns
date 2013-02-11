package fluentreflection;

import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.Collection;

public class FluentPersonFactory extends ReflectiveFactory<Person> {

    private FluentPersonFactory() {
        super(Person.class);
    }

    public static FluentPersonFactory person() {
        return new FluentPersonFactory();
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

    protected void validate() {
        Collection<String> missingParameters = new ArrayList<String>();
        if (Strings.isNullOrEmpty(getField("firstName"))) {
            missingParameters.add("first name");
        }
        if (Strings.isNullOrEmpty(getField("lastName"))) {
            missingParameters.add("last name");
        }
        if (object.isAged() == null) {
            missingParameters.add("age");
        }
        if (!missingParameters.isEmpty()) {
            throw new CreatePersonException(missingParameters);
        }
    }

}
