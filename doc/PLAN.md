# Cell Society Design Plan
### Team Number 14
### William Convertino
### Tim Jang
### Quentin MacFarlane
### Alexis Cruz-Ayala

## Design Overview
We plan on initializing the Scene in Main and then passing it into the Display class as an argument so that the Display
class can handle changing the scene. We also plan on having a Logic class which handles the logic behind which cells are
going to be updated as living and which cells are going to be updated as dead on the next tick of the display. We pass
the grid-to-be to the Display class so that Display can update the scene to show the next state of the grid (the grid-to-be). 
We also have an I/O package to handle file reading and parsing. There is a class for reading the CSV files and another 
class for reading the settings files. Also in the I/O package is a method to save a current grid to a CSV file. We plan on 
creating logic subclasses for each different application because they update the grids using different techniques. 
Finally, we will have a controller classes to link together all the different parts. The main controller class deals with
the higher level ideas, while the logic controller will load and initialize the algorithms.

## Design Details

Our classes work together using the controller classes. If we have an error, our Logic or IO classes will
throw it, and the Controller will catch it and send it to the Display. The errors displayed to the users will all be contained 
in an English.properties file. Our Logic will implement an inheritance hierarchy
where there will be a superclass and then the subclasses will be specific to each of the four applications, running each
of the different algorithms on the grid. The logic sends a new grid over to the controller, which sends it over to display
so that the display can show the new state of the grid. 

## Design Considerations

#### Design Issue #1

 * We initially had the Logic class read the CVS and SIM files, and initialize the grid with only
a file name.

 * We decided to move this functionality to the LogicController class, and create new IO classes to deal
with actually reading the files.

 * Trade-offs: While the first alternative reduced the strain of the system on the main Controller class,
it also violated the Single Responsibility principle, as our Logic classes would be responsible for both
the reading of files and the execution of their algorithms.


#### Design Issue #2

 * We were deciding how we were going to initialize the display, scene, buttons, and the grid, 
and how to communicate between each of the classes. We were planning to make the buttons and the scene in the display
class.

 * Create the scene in the main class and the buttons in the controller class and pass them down to the display. 

 * Creating the buttons and scene in the display gives more control in the display, and makes it easier for the display
to change within the display functionality. However, by having the buttons in the controller class, it makes other classes
that need access to the buttons have easier access. 



## User Interface

Here is our amazing UI:


## Team Responsibilities

 * Will Convertino - Developing the Controller and LogicController classes, including Error catching and 
algorithm initialization.

 * Tim Jang - Responsible for creating & initializing the display and updating the shown grid state.

 * Quentin MacFarlane - Responsible for part of the IO classes, as well as the Language files and error display.

 * Alexis Cruz-Ayala - Responsible for implementing the algorithm base, the GOL, and managing the Grid class. 


#### Proposed Schedule

Sunday: Have our first meeting and discuss initial project development

Monday: Have the first stage completed (with tests)

Wednesday: Have a second meeting and decide upon how to implement changes.

Sunday: Have a third meeting, have the second stage largely done.