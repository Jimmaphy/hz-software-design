# HZ Software Design (CU75020V2)

The first elective course of the study program at HZ for Software Engineering is Software Design.
During this course, Java will be used to explore several Design Patterns.
This repository holds my own implementation of a pattern, example patterns and school exercises.
Over time, this document will be filled with information on the different design patterns.
Examples will be added which will reference my personal examples.

## Adapter Pattern

_+ Single Responsibility, + Open/Closed Principle, - Increased OOP Complexity_

The Adapter Pattern is used to create a class which converts an object with a certain object to match another.
An example could be a library provided data in XML format, while the program works with JSON.
An extra class can be created to convert the XML document to match the functionality of the JSON object.

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
The client is expecting a specific interface, Bash in the example, called the ```client interface```.
The class being converted, CMD in the example, is called the ```service```.
This is the class that provides the functionality we would like to use.
The ```adapter```allows the client to use the service.
