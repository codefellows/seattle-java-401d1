# ![CF](http://i.imgur.com/7v5ASc8.png) Authorizing Users to View Secured Content

## Learning Objectives
* Students will be able to allows users to log in to their accounts being
  authenticated with Spring Auth
* Students will be able to use Spring Auth to authorize or restrict users
  from seeing other users's private data.
* Students will be able to create databases modeling user relationships
  like mutual friendships on Facebook
* Students will be able to draw a distinction between a user being authenticated
  (logged in) and being authorized (allowed to see/access) some content


## Lecture Outline
* Define the four components of what type of resources need to be protected
  with Auth:
  * Routes - unauthorized users shouldn't be able to access some pages at all.
  * UI - unauthorized users shouldn't see UI like an edit button they don't
    don't have permissions to touch unless they were an administrator or owner.
  * Actions - unauthorized users shouldn't be able to perform actions on API
    endpoints.
  * Server Logic - our application should be able to programmatically determine
    if a user has authorization to perform certain actions, and execute
    accordingly.
