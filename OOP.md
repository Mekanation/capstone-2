Object Oriented Programming Concept Questions

As you should know by now, there are 4 pillars of Object Oriented Programming.

********************
1. Encapsulation



Encapsulation in Java is a mechanism of wrapping the data (variables) and code acting on the data (methods) together as a single unit. In encapsulation, 
the variables of a class will be hidden from other classes, and can be accessed only through the methods of their current class. Therefore, it is also known as data hiding.

If you look at my hero and my alien classes, I keep all things they use private then call them in the render method of the game screens.
 I could have thrown every single object logic and entity into the render method of the GameMain, but it would have been hard to follow(Note: Games that are sold on steam as of right now have 10k lines of code in the render method.)







********************
2. Inheritance

Inheritance can be defined as the process where one class acquires the properties (methods and fields) of another. 
With the use of inheritance the information is made manageable in a hierarchical order.

I had to inherit the rectangle class on all of my sprites in order to make the collision work. 




********************
1. Abstraction
As per dictionary, abstraction is the quality of dealing with ideas rather than events. For example, when you consider the case of e-mail, 
complex details such as what happens as soon as you send an e-mail, the protocol your e-mail server uses are hidden from the user. 
Therefore, to send an e-mail you just need to type the content, mention the address of the receiver, and click send.

Likewise in Object-oriented programming, abstraction is a process of hiding the implementation details from the user, only the functionality will be provided to the user. 
In other words, the user will have the information on what the object does instead of how it does it.



I made an abstract bullet class that forces the developer(me) to implement the updateBullet method which behaves differently if spawning from the hero, or the alien. 



********************
1. Polymorphism
   

Polymorphism is the ability of an object to take on many forms. The most common use of polymorphism in OOP occurs when a parent class reference is used to refer to a child class object.

Any Java object that can pass more than one IS-A test is considered to be polymorphic. In Java, all Java objects are polymorphic since any object will pass the IS-A test for their own type and for the class Object.

It is important to know that the only possible way to access an object is through a reference variable. A reference variable can be of only one type. Once declared, the type of a reference variable cannot be changed.

The reference variable can be reassigned to other objects provided that it is not declared final. The type of the reference variable would determine the methods that it can invoke on the object.

A reference variable can refer to any object of its declared type or any subtype of its declared type. A reference variable can be declared as a class or interface type.


My GameMain class extends Game which extends application listener, which GameMain has several game screens which implement Screen.



Please write a 1-3 paragraphs explaining these 4 concepts further.  Please provide a sufficient enough explanation about these pillars,
 as well as some examples to illustrate the practical use cases of these principles.  



