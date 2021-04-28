This will be a quick tutorial in how to use [JarGame](https://github.com/Joshyx/JarGame) to make a game.


### Step 1: Setup
Make sure you have downloaded [JarGame](https://github.com/Joshyx/JarGame) and imported it into your project.
Create a Main class with a main() method which will be run at the start of the program.
Now, import net.joshix.jargame.main and write JarGame.init() at the beginning of your main() method.
This should look like this:

```java
import net.joshix.jargame.main.JarGame;

public class Main() {
   public static void main(String[] args) {
      JarGame.init();
   }
}
```
Now, when you run the program, you should see something like this in the console: `JarGame v1.2 loaded succesfully`

### Step 2: Creating a window
To create a window, simply import net.joshix.jargame.screen and call Window.createWindow(TITLE, WIDTH, HEIGHT) after the JarGame.init() method.
Window.createWindow(TITLE, WIDTH, HEIGHT) takes in three parameters:
* TITLE is the title of the window, you can just use the name of your game as a String
* WIDTH is the width of your window as an integer
* HEIGHT is the height of your window as an integer

This should look like this:
```java
import net.joshix.jargame.main.JarGame;
import net.joshix.jargame.main.Window;

public class Main() {
   public static void main(String[] args) {
      JarGame.init();

      Window.createWindow("My Own Game", 1920, 1080);
   }
}
```
When you now run the program, a window should open with the given width, height and the name of your game
