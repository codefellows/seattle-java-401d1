# ![CF](http://i.imgur.com/7v5ASc8.png) Assigning Tasks To Users


## Resources

## Learning Objectives
* Students will be able to model complex database relationships for entities
  that are associated with users, and change state over time.
* Students will be able to configure a "middleman" Spring server to intercept
  requests between an Android client and a Firebase database to perform
  additional logic and trigger special events.
* Students will be able to detect when a user broadcasts GPS information
  placing them near an important place and trigger a state change in the
  database.

## Lecture Outline
* Start the lecture by drawing ERD diagrams modeling the existing tables and
  relationships in the current database.
* Design a new `Delivery` entity that will be associated with two users and two
  locations.
* Show how to create a table that composes the `Delivery` entity by referring
  to `userIds` and `locationIds` in the user and location tables.
* Add another column to the `Delivery` table that represents what state the
  delivery is in:
  * **Ordered** - the delivery has been ordered, but it's not been shipped.
  * **Shipped** - the delivery has left the warehouse and is in transit to
    the final destination.
  * **Delivered** - the delivery made it to the final location and the delivery
    is complete.
    
* Add a Spring server that exists between the client and the
  database.
* Configure the server to apply logic to user location changes,
  perform proximity detection, and automatically manipulate
  the state of a delivery in a database to change from
  "ordered" to "shipped" or "shipped" to "delivered"
