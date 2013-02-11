package fluent.fluentreflection;

import java.lang.reflect.Field;

public abstract class ReflectiveFactory<T> {

    protected final T object;

    protected ReflectiveFactory(Class<T> type){
        try {
            this.object = type.newInstance();
        } catch (Exception e) {
            throw new FactoryCreateException();
        }
    }

    protected void setField(String fieldName, Object newValue) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, newValue);
        } catch (Exception e) {
            System.out.println("Unable to create instance of factory");
        }
    }

    protected String getField(String fieldName) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return (String) field.get(object);
        } catch (Exception e) {
            return null;
        }
    }

    public T create() throws CreatePersonException {
        validate();
        return object;
    }

    protected abstract void validate();

}
