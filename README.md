# java-paint-gui

## Description
- This is a basic paint gui built with java swing
- Basic functions include 
	- drawing circle, lines, rectangles, free lines
	- filling in shapes
	- changing colors
	- saving canvas state to file and then backing up the state
	- undo/redo
- Executable version is in paint.jar
	- will need java to run this

## High level explanation
![alt diagram](https://github.com/selden-lin/java-paint-gui/uml_diagram.jpg)
- Project follows MVC architecture
- Input is read through the PaintOptionPanel and the canvas mouse listener
- Controller holds instance of paintModel which holds canvas paint state
	- shapes generated using factory builder design pattern
	- modifiers like color and fill implemented with decorator design pattern
- file handling is handled in the PaintMenu class using basic FileWriter and Scanner classes