# HZ Software Design (CU75020V2)

The first elective course of the study program at HZ for Software Engineering is Software Design.
During this course, Java will be used to explore several Design Patterns.
This repository holds my own implementation of a pattern, example patterns and school exercises.
Over time, this document will be filled with information on the different design patterns.
Examples will be added which will reference my personal examples.

## Patterns

### Adapter Pattern

The Adapter Pattern or Wrapper is used to create a class which a certain interface to match another.
An example could be a library provided data in XML format, while the program works with JSON.
An extra class can be created to convert the XML document to match the functionality of the JSON object.

Another example is the sockets.
A European plug can't be put into an American socket, an adapter is used to allow this behavior.
The same principle applies to the Adapter pattern, one interface is converted to another.

The example used in this document will be the conversion from the Windows CMD to Linux Bash.
The Windows CMD provided a command called ```dir``` which lists the contents of the current directory,
while Linux Bash uses the ```ls``` command to achieve the same goal.
The program we're writing wants to utilize the Windows command line,
without create much extra code to convert every single part.
An adapter will be used to wrap an instance of CMD and make it behave like Bash,
allowing the use of ls in CMD.

The first step is to create both classes with their separate function.
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
The methods of Bash will be overridden to "emulate" the program expects.

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
which isn't necessary in every case;
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

### Facade Pattern

The Facade Pattern is a pattern designed to help with complicated operations.
A program or library might have a complicated set of actions or objects.
Using facade adds an abstraction layer to make the interactions straightforward.
Functionality and options are exchanged for simplicity.
A facade can also be used whenever the client only wants a subset of provided functionality.

As an example, a project has been created surrounding ASCII art.
An art library provides drawing functionality but is rather complicated.
In order to draw a shape onto the screen, an object has to be created and then drawn.
The client in this scenario has to go to quite a lot of steps to get things working:

```java
clearConsole();

Ascii art = new Rectangle('X', 4, 4, 4, 4);
Ascii otherArt = new Triangle('O', 4, 4, 8, 5);
          
art.Draw();
otherArt.Draw();
```

The code shown above may seem easy, but console management is for the client.
The clearConsole function is written inside the client instead of the library.
The facade pattern will allow this to be abstracted away in a single interface,
while combining all the different classes provided by the art library into that single interface.

```java
public class AsciiFacade {
    public static void ClearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    
    public static void DrawRectangle(char character, int width, int height, int x, int y) {
        Rectangle rectangle = new Rectangle(character, width, height, x, y);
        rectangle.Draw();
    }
    
    public static void DrawTriangle(char character, int base, int x, int y) {
        Triangle triangle = new Triangle(character, base, x, y);
        triangle.Draw();
    }
}
```

By combining all the options from different classes and by adding missing functionality,
a simple interface was created to perform the same actions as before.
This is immediately reflected by the code inside the client:

```java
AsciiFacade.ClearScreen();
AsciiFacade.DrawRectangle('X', 4, 4, 4, 4);
AsciiFacade.DrawTriangle('O', 8, 8, 5);
```

### Strategy Pattern

The strategy pattern is designed to help whenever a certain operation can be done in multiple ways.
By splitting the different operations up into seperated classes,
it becomes easy to swap them out and change the functionality of a context.
The context being the location where the different strategies are used.

In order to utilize the pattern, an interface is created that holds the algorithm.
The interface only holds a single function, 
since the subclasses will only implement their version of the algorithm.
An example of an interface that can be used for the strategy pattern follows:

```java
public interface FoodPrepStrategy {
    String[] prepareFood(String food);
}
```

As the code shows, the strategy pattern is going to be used to prepare food.
The subclasses will each implement a different way to prepare food.
Each of them will override the function and create their own implementation.
These implementation can then be used in a context, the place where the strategy is utilized.

```java
public class FoodContext {
    private FoodPrepStrategy Strategy;
    
    public FoodContext(FoodPrepStrategy initialStrategy) {
        this.Strategy = initialStrategy;
    }

    public void setStrategy(FoodPrepStrategy strategy) {
        Strategy = strategy;
    }

    public void prepareFood(String food) {
        for (String step : this.Strategy.prepareFood(food)) {
            System.out.println(step);
        }
    }
}
```

The context allows the different strategies to be used and swapped at the clients will.
The context can now be used, together with instances of different strategies, to prepare food.
It doesn't matter which strategy is used, the code does exactly what we ask.
A main function will now look something like:

```java
FoodContext foodContext = new FoodContext(new WokStrategy());
foodContext.prepareFood("Egg Fried Rice");

foodContext.setStrategy(new OvenStrategy());
foodContext.prepareFood("Apple Pie");
```

## Assignments

### Refactoring

[Refactor project copied from sindresorhus](https://github.com/sindresorhus/pokemon)

**Dynamically Loading Languages**

The first thing I noticed was the list of languages on top of the file.
This list was hardcoded, which limits the ability of the application to quickly adapt.
Adding a new language currently involves creating a json file with the right information,
as well as adding the language to the list below within the code:

```javascript
const languages = new Set([
	'de',
	'en',
	'fr',
	'es',
	'ja',
	'ko',
	'ru',
	'th',
	'zh-Hans',
	'zh-Hant'
]);
```

By using the ```fs``` library from Node.js, it becomes easy to get these names dynamically.
This removes the need to manually add hardcoded languages whenever one is added.
Removing the hardcoded values makes the code shorter, and more maintainable.

```javascript
/**
 * Retrieves the languages from the data directory.
 * The files within the directory are retrieved and their extension is removed.
 *
 * @returns {Array} An array containing the languages found in the directory.
 */
function getLanguagesFromDirectory() {
	return fs.readdirSync('./data/').map(
		file => file.split('.')[0]
	);
}
```

**Placement of top-level code**

Randomly throughout the file, bits of top-level code would make an appearance.
In order to improve readability of the document, top-level code was moved to the top.
This seperated the top-level code from the callable function below it.

**Removal of unneccesary top-level variables**

The first variable that was considered unnecessary was the ```pokemon``` variable.
This variable stored the English list of Pokémon names by default.
The value of this variable however, only saw use in the ```getLocalizedList``` function.
Whenever the English list would be request, the value of the variable would be returned;
otherwise, the right list was loaded and returned.
The function was modified to simple get the list of the required language.

```javascript
const pokemon = require('./data/en.json');
```

The second and third variable are variables for loading random Pokémon in a specified language.
Again, the variables were only used in a single function.
Moving them to that function made more sense.

```javascript
const uniqueRandomArray = require('unique-random-array');
const randomNameGenerators = new Map();
```

**DocStrings**

None of the function where documented using jDoc. I added them using the expected format to adhere to this.
It creates more inline description, and whenever someone would use our module their IDE of choice will help them along.

**Exports at the end of the file**

Throughout the file, random export statements would pop up.
Some of them covering function, some variables, some inline functions.
In order to clean this up, the exports were moved to the bottom of the page.
The inline function are converted to full function to adapt to this change.

```javascript
exports.random = (language = 'en') => { ... };
exports.getName = (id, language = 'en') => { ... };
exports.getId = (name, language = 'en') => { ... };
exports.languages = languages;  
exports.all = getLocalizedList;
```

```javascript
module.exports = {
	"languages": languages,
	"all": getLocalizedList,
	"random": random,
	"getName": getName,
	"getId": getId
}
```

**Removing trivial node packages**

The code uses the unique-random-array node module.
While this makes the code cleaner, it requires a module to run for something trivial as picking a random entry.
Therefore, the code was changed to remove this package.
It does mean it's more complicated, though the uniqueRandomArray variable didn't really specify what it did anyway...

```javascript
const uniqueRandomArray = require('unique-random-array');
const randomNameGenerators = new Map();

if (randomNameGenerators.has(language)) {
    return randomNameGenerators.get(language)();
}

const list = getLocalizedList(language);
const random = uniqueRandomArray(list);
randomNameGenerators.set(language, random);

return random();
```

```javascript
const localizedNames = getLocalizedList(language);
const randomIndex = Math.floor(Math.random() * localizedNames.length)
return localizedNames[randomIndex];
```
