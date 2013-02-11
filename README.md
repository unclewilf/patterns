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

Often this means a class could have setters which return a value instead of void,
to allow chaining of commands;

Fluent reflection:
Here I have created an example with all of the setters taken out of my java bean,
and used a static factory pattern to create the object using reflection.
A Spring bean with factory-method at prototype scope has been used for dependency injection

Pattern usage:
For building complicated domain entities or value objects in a more readable way

Factory example came from here:
http://f3yourmind.net/blog/software-development/factories-builders-and-fluent-interfaces

Stubbing example came from here
http://jakegoulding.com/blog/2012/01/09/stubbing-builder-pattern-in-mockito/
