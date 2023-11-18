# HZ Software Design (CU75020V2)

The first elective course of the study program at HZ for Software Engineering is Software Design.
During this course, Java will be used to explore several Design Patterns.
This repository holds my own implementation of a pattern, example patterns and school exercises.
Over time, this document will be filled with information on the different design patterns.
Examples will be added which will reference my personal examples.

## Adapter Pattern

The Adapter Pattern or Wrapper is used to create a class which a certain interface to match another.
An example could be a library provided data in XML format, while the program works with JSON.
An extra class can be created to convert the XML document to match the functionality of the JSON object.

Another example is the sockets.
A European plug can't be put into an American socket, a adapter is used to allow this behavior.
The same principle applies to the Adapter pattern, one interface is converted to another.

The example used in this document will be the conversion from the Windows CMD to Linux Bash.
The Windows CMD provided a command called ```dir``` which lists the contents of the current directory,
while Linux Bash uses the ```ls``` command to achieve the same goal.
The program we're writing wants to utilize the Windows command line,
without create much extra code to convert every single part.
An adapter will be used to wrap an instance of CMD and make it behave like Bash,
allowing the use of ls in CMD.

The first step is to create both classes with their seperate function.
The difference is clear as day, CMD has a ```dir()``` function and bash a ```ls()``` function.

```java
public String dir() {
   return "Contents of " + this.directory;
}
```

```java
public String ls() {
    return "The contents of " + this.pwd;
}
```

By creating a class the extends Bash, the conversion can begin.
The new class now has the interface of Bash, and can be used in any place an instance of Bash is expected.
The only thing left to do now is to create an internal instance of CMD to interact with.
The methods of Bash will be overriden to "emulate" the program expects.

```java
public class CmdAdapter extends Bash {
    /** Convert the Windows commandline to be compatible with Linux commands. */
    private Cmd commandLine;

    public CmdAdapter() {
        this.commandLine = new Cmd();
    }

    @Override
    public String ls() {
        return this.commandLine.dir();
    }

    @Override
    public void cd(String newPath) {
        this.commandLine.cd(newPath);
    }
}
```

There is some vocabulary associated to the adapter pattern.
The ```client``` is the program that is running.
The client is expecting a specific interface, Bash in the example,
called the ```client interface``` or ```target```.
The class being converted, CMD in the example, is called the ```service``` or ```adaptee```.
This is the class that provides the functionality we would like to use.
The ```adapter```allows the client to use the service.

Depending on the situation, one might consider requesting an instance of the service.
This could happen when you want to adapt a full interface instead of a single class,
or if you want the user to have more control over the instance used.
The downside of this method is that the user now has to instantiate the object,
which isn't necesarry in every case;
or you just want the adapter to work with a specific configuration.
The choice is really between flexibility and encapsulation.

```java
public class Adapter {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public request() {
        this.adaptee.message();
    }
}
```
