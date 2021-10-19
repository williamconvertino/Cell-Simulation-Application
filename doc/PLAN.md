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

|**Logic**| Collaborates With|
|---|---|
|Getting the neighbors of a cell        ||
|Updating each cell on each tick of application | |
|Creating a new grid for each tick | |
|Sending the new grid over to Controller |Controller |

|**Display**| Collaborates With|
|---|---|
|Create a control panel for the user (upload file, pause, etc.)  ||
|Update the scene at each tick | |
|Get the stage and scene from Main |Main|

|**Input Output**| Collaborates With|
|---|---|
|Save current grid configuration from Display  |Display|
|Read the file and parse the data ||
|Send the parsed file over to Logic |Logic|

|**Controller**| Collaborates With|
|---|---|
|Get next state of Grid and pass it to Display  |Logic, Display|
|Send I/O data to Logic |I/O, Logic |
|Send the scene from Main to Display so the Display can modify it |Main, Display|
|Keep track of the current Grid state for logic controller  |Logic|

## Design Details

Our classes work together using the controller classes. If we have an error, our Logic or IO classes will
throw it, and the Controller will catch it and send it to the Display. The errors displayed to the users will all be contained 
in an English.properties file. Our Logic will implement an inheritance hierarchy
where there will be a superclass and then the subclasses will be specific to each of the four applications, running each
of the different algorithms on the grid. The logic sends a new grid over to the controller, which sends it over to display
so that the display can show the new state of the grid. 

**Use Case #1**: The file runs, user pauses on a specific configuration and saves the current grid
1. Use case begins when user runs the file
2. User hits the pause button, causing the state of the button to say "Resume" now and causing the animation to stop on the
current configuration of the grid
3. The user hits a "save" button and inputs the name they choose for the file
4. The display passes this button event to the controller which calls the saveFile method from a FileHandler class in I/O
5. The file is saved on the computer of the user

**Use Case #2**: The user uploads a file with an invalid simulation type
1. Use case begins when user uploads a file to the application using a button from the control panel in the 
Display class. 
2. The file is passed to the I/O classes so that the I/O classes can parse the data
3. The I/O parses the data and sends this data to a controller
4. The controller sees that there is data in the file that does not make any sense
5. It catches the error and gives it to the Display class so that the Display class can show the error in a user-friendly
way such as a pop-up
6. Program does not crash

**Use Case #3**: The user loads a Game of Life file into program and then after a while the user loads a Spreading Fire file 
into the program
1. Use case begins when the user uploads the Game of Life file from a button on the display
2. The file runs with constant communication between Logic, Controller, and Display - the logic is creating a new grid at every 
tick based on the Game of Life algorithm and is sending this grid to the controller which sends it over to Display so that the 
Display follows Single Responsibility and is only concerned with displaying the grid retrieved from Logic.
3. Then, after a while, the user presses the upload file button again and uploads a Spreading Fire application.
4. This causes the Display to reset back to its original state via a reset() method. 
5. Everything in Logic and Controller was reverted back to its original state before the Game of Life program started 
and the Spreading Fire application now runs on the Display.



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