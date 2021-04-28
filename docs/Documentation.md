layout: page
title: "Documentation"
permalink: /URL-PATH/

To help you making a game with [JarGame](https://github.com/Joshyx/JarGame), I've created a documentation. Here you'll find all the classes you might need and explanation on how to use them.




## JarGame
> class net.joshix.jargame.main.JarGame

The main class of JarGame.

### Attributes
* **static running**\
  If JarGame is currently running\
  _Type: boolean_

### Methods
* **static init()**\
  Has to be called at the beginning of the game, makes sure everything is setup correct\
  _Return Type: void_
  
* **static close()**\
  Stops the program\
  _Return Type: void_\
  
  
## Window
> class net.joshix.jargame.main.Window

The window class of JarGame. Used for everything with windows.

### Methods
* **static createWindow(String title, int width, int height, KeyListener keyListener)**\
  Has to be called to create a window.\
  **Parameters:**
  * title:\
    The title of the window (required)\
    _Type: String_
  * width:\
    The width of the window (required)\
    _Type: int_
  * height:\
    The height of the window (required)\
    _Type: int_
  * keyListener:\
    The KeyListener for the window(optional)\
    _Type: KeyListener_

  _Return Type: void_
  
* **static close()**\
  Stops the program\
  _Return Type: void_
