# Cell Society Design Final
### Names

## Team Roles and Responsibilities

William Convertino - Created the Grid and Cell classes, the base neighborhood and shape classes & their implementation,
Controller and Logic Controller, Error Handling, and the second display. I also created some of the test files, set up
the button functionality, and contributed heavily to the design of the project.

Tim Jang - 
Quentin MacFarlane - 
Alexis Cruz-Ayala - 

## Design goals

The core design idea of our project shifted when we received the final set of changes.

We initially just wanted a system that would be able to run the simulations successfully,
and allow users to create new simulation types with ease. The key design goal here was to 
make the additional simulation types and any new files easy to add. We were fairly successful with
our initial design, but the new changes would have been difficult to implement.

We decided to rebuild much of the design to account for these changes. Our new design goals included
the ones previously mentioned, as well as the ability to add new border types, neighborhood patterns,
and shapes. We also wanted to be able to add new types of these features individually. For example,
if you wanted to add a new border, it should be as simple as creating a new border class, without needing
to create any additional files to make it compatible with each neighborhood and shape.

#### What Features are Easy to Add

With our final design, we were able to accomplish all of our design goals. Adding new simulations is
quite easy, requiring you only to extend the parent simulation class, initialize any new variables
in the constructor, and your logic to the updateNextGridFromCell method, and add an initialization 
method in the LogicController. Adding new sim files is also quite easy, as you can simply add any matching
keys and values in any order. Any unnecessary keys are ignored, and any missing keys have automatic error 
handling.

The new features are all also quite easy to implement. The new neighborhood patterns are the easiest, as
you only need to extend the parent class and add 1 method. The border patterns are quite easy too, as you
only need to make a new Grid child class and change the getNeighbors method. The hardest one to integrate is
a new shape, but this is mostly a matter of display. The logic is quite simple; you can extend the ShapeManager
class and fill out the required methods to establish which cells are considered its neighbors. Making it 
display properly is a bit more challenging, and requires you to make a Display class for the shape. This isn't
terribly difficult to do, and only requires the one class, but it still has a bit more overhead than the rest of the
features.

## High-level Design



#### Core Classes


## Assumptions that Affect the Design

#### Features Affected by Assumptions


## Significant differences from Original Plan


## New Features HowTo

#### Easy to Add Features

#### Other Features not yet Done

