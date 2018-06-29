# ![CF](http://i.imgur.com/7v5ASc8.png) Tracking User Reputations


## Learning Objectives
* Students will be able to add another model to an already complex database
  with many entities and relations.
* Students will be able to author a database that tracks user reputations for
  a social application.

## Lecture Outline
* Explain that social applications require reputation systems
  to make sure that users are aware of who they're interacting
  with.
* Shoppers buying products from third-party sellers on Amazon
  want to make sure they don't get a bad deal with someone that
  has a reputation for shipping faulty products.
* Shoppers want to be able to choose to buy things from sellers
  with the best reputations, or choose to balance the cost of
  what they're buying with a user's reputation themselves.
* Especially with now-prevalent ride-sharing and task-distribution
  apps users want to make sure they're interacting with someone
  that maintains a good reputations
  
* Let's build our own reputation system that allows users to
  rate other users, and leave comments describing what is good
  and bad about other users.
* We'll build a system that displays this information in
  aggregate, so users can see the overall reputation of someone,
  as well as allowing users to see someones reputation in fine
  grain detail so they can see exactly what sort of things other
  users had to say.
  
* Draw the ERD diagram of the (now quite complex!) database.
* Introduce a new table to model a single point of feedback
  for a user.
* Introduce another new table that creates a 1:M relation
  between users and reputation feedback they have seen
  
* Create SQL queries that query for all of someone's reputation
  history
* Create a SQL query that summarizes a user's reputation.
* Show how you can use Java to post-process information to
  manipulate data in ways that may not be easy to do in SQL
