# Project 0: Traffic Animation

* Author: Robbie Gill
* Class: CS 121 Section #035
* Semester: Summer 2019

## Overview
This program creates a scalable animation of a Ship moving across the screen, an avatar observing and some background features. 


## Compiling and Using

To compile, execute the following command in the main project directory:
```
$ javac TrafficAnimation.java
```
Run the compiled class with the command:
```
$ java TrafficAnimation
```

If you wish to an create a scaling object of your own or modify an existing object, use the 
dimenesionScalerX and dimensionScalerY methods. These methods take a parameter that represents the x or y position as they are represented in the initial window:
```java
initWidth = 600;
initHeight = 400;
``` 
and returns an equivialant scaled value, based on the```getwidth()``` or  ```getheight()``` method value of the current window. 

Note: these methods will not scale as intended if  ```initWidth or initHeight``` values are changed.
 
Example code of dimensionScalerX:
when ```getWidth()``` = ```initWidth```:
```dimensionScalerX(35)```is equal to ```35```.

 If we rescale the window on the X axis so that ```getWidth()```is equal to ```700```.
```dimensionScalerX(35)``` is equal to ``` 41```.
```java
public int dimensionScalerX(int var) {
	int width = getWidth();
	int result = ((width/6)*var)/100;
	return (result);
		}
```
If you wish to create or modify a moving object that relys on an```(int x, int y)``` system. Use the ```xOffset``` variable as an origin point , by creating an expression with the ```int x ``` or ```int y``` parameters and ```xOffset```.  For example if I were to create a Rectangle object that travels across the screen I would use: 
```java
g.drawRect(xOffset + dimensionScalerX(25), dimensionScalerY(167), dimensionScalerX(250), dimensionScalerY(10));
```

## Sources used
-Useful code I found for changing the font size of text in swing.
[Setting font size in java](https://stackoverflow.com/questions/18249592/how-to-change-font-size-in-drawstring-java)
-A useful guide I used for this README
(https://raw.githubusercontent.com/BoiseState/CS121-Public/master/projects/README_EXAMPLE.md)

