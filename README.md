patterns
========

Useful Java Design Patterns

========================================

Fixture:
This pattern is particularly useful when creating complicated objects with a lot of variation.

Pattern usage:
It is a nice improvement on the builder pattern, to elegantly combine many builders,
or to persist created objects in the database.

========================================

State:
Allows an object to alter its behaviour when its internal state changes.
The object will appear to change its class.

Pattern usage:
You should use the State pattern when the behaviour of an object should be influenced by it's state,
and when complex conditions tie object behaviour to it's state.

You can also use role interfaces so not all classes
http://elegantcode.com/2010/03/19/dont-give-up-on-the-state-pattern-just-yet/

========================================

Double Dispatch:
This allows method overloading using objects of the same interface.

Pattern usage:
If you have an overloaded method in your repository for different implementations of the specification interface.
You might not know which specification you are going to have;
This way you ask the specification to call the correct method in the repository.

========================================

Fluent:
The term fluent interface was coined by Eric Evans who wrote Domain Driven Design,
and describes the process of making your API more understandable to read.

JMock is a nice example of a fluent interface:
mock.expects(once()).method("m").with( or(stringContains("hello"),
                                          stringContains("howdy")) );

Fluent bean:
This shows a class with setters which return a value instead of void,
to allow chaining of commands.
This means complicated construction logic still lives in the class,
but fine for simpler objects.

Still means all setters are present.
Could use a constructor, but I think this should be for mandatory fields only,
rather than a way of passing everything in.

Fluent factory:
This shows an example of using a factory to provide a fluent interface to the bean,
with standard getters and setters.
The advantage of this technique, is complicated construction logic can be hidden away,
but still leaves boiler plate getters and setters.

Fluent reflection:
Here I have created an example with all of the setters taken out of my java bean,
and used a static factory pattern to create the object using reflection.
A Spring bean with factory-method at prototype scope has been used for dependency injection.

The disadvantage here is using reflection means creating the bean takes fractionally longer,
and the code to do the reflection is a little complicated.
This leaves you with a really clean, understandable domain object.

Pattern usage:
For building complicated domain entities or value objects in a more readable way

Factory example came from here:
http://f3yourmind.net/blog/software-development/factories-builders-and-fluent-interfaces

Stubbing example came from here
http://jakegoulding.com/blog/2012/01/09/stubbing-builder-pattern-in-mockito/

========================================

Decorator:
(From GOF) Allows for the dynamic wrapping of objects in order to modify their existing responsibilities and behaviours.

Explained nicely here:
http://java.dzone.com/articles/design-patterns-decorator

This can be done by subclassing.
But too much subclassing is definitely a bad thing.
As you add more behaviours to a base class,
you will soon find yourself dealing with maintenance nightmare,
as a new class is created for each possible combination.

Overuse of the Open/Closed principle can lead to abstract and complex code.
This principle should really only be used in places where code is least likely to change.