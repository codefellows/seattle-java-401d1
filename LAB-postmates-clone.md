# ![CF](http://i.imgur.com/7v5ASc8.png) TaskMaster

## Resources
* [Adding Maps](https://developer.android.com/training/maps/index.html)

## Feature Tasks
Recreate a Postmates-like task app where users can create requests for someone
else to go to a location, perform a task, and bring them something back.

This ties together functionality from the last several labs:
* Allow users to sign in and maintain an identity
* Allow users to search for places, or annotate a location on the map.
* Allow users to broadcast their location as they move around the map.

Users should be able to choose a location on the map and give instructions for
what someone should do there. This action creates a "Task".

Other users should be able to browse open tasks and choose one they want to
perform. If they choose to accept a task the task information should be updated
in the database and no one else should be allowed to choose it.

If a user accepts another user's task the task creator should be able to track
the location of the other user performing the task.

Work with your teammates to determine the best way to model tasks in the
firebase database.

The task should have two locations associated with it:
* **Task Location** - the location where the task should be performed.
* **Delivery Location** - the location where the result of the task should be
  dropped off.
  
The task should have one property which represents what state the task is in.
* **Available** - the task has been created, and is publicly available, but no
  other user has claimed it yet.
* **Started** - someone has claimed the task and is on their way to the task
  destination.
* **Delivering** - the user has performed the task and is delivering the result
  to the task creator.
* **Finished** - the task is totally complete.

Add logic in the application to automatically progress through Task states as
users arrive at the task location, then leave on their way to the delivery
location.
  
## Testing  
* Write a test to create a Task
* Write a test ensuring tasks are properly written to the database with mocks
* Write a test ensuring tasks are properly read from the database with mocks
* Write a test ensuring you can retrieve open, unclaimed tasks
* Write tests making sure locations associated with a task properly detect
  when a user's location is within a certain distance and they're considered
  "there"
* Write tests making sure a task progresses through it's states properly

## Documentation
* In your `README.md` include screenshots of your app.
* Include a sample of how information is structured and stored in your Firebase
  database.

## Stretch Goals
* Use Firebase messaging to notify users when their task changes state 

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
