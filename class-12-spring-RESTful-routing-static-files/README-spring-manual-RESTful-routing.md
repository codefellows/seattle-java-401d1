# ![CF](http://i.imgur.com/7v5ASc8.png) RESTful Routing

## Learning Objectives
* Students will be able to manually configure a server with RESTful routes.

## Resources
* [Spring Guides: Serving Web Content](https://spring.io/guides/gs/serving-web-content/)
* [RESTful Routing](http://restfulrouting.com/#resource)

## Lecture Outline
* Review RESTful routing.
* Review the steps to configure a simple Spring server.
* Get a simple Spring server running.
* Create a controller for the RESTful resource you're modeling.
  * Configure the route prefix with `@Controller("/products")`
* Manually configure the GET/POST/PUT/DELETE routes
  * Annotate methods with `@GetMapping`, `@PostMapping`...

### RESTful Routing Cheatsheets
Here's an excellent resource to remind yourself what RESTful routing should look
like for any resource in your application. A `resource` is a "thing" in your
application.

Consider setting up RESTful routes for a user to create, read, update and delete
their profile on a website.

#### Single-thing
<table><thead>
<tr>
<th>Action</th>
<th>HTTP Method</th>
<th>Url</th>
<th>HTML form?</th>
<th>CRUD</th>
</tr>
</thead><tbody>
<tr>
<td>SHOW</td>
<td>GET</td>
<td>/profile</td>
<td></td>
<td>READ</td>
</tr>
<tr>
<td>NEW</td>
<td>GET</td>
<td>/profile/new</td>
<td>Yes</td>
<td></td>
</tr>
<tr>
<td>CREATE</td>
<td>POST</td>
<td>/profile</td>
<td></td>
<td>CREATE</td>
</tr>
<tr>
<td>EDIT</td>
<td>GET</td>
<td>/profile/edit</td>
<td>Yes</td>
<td></td>
</tr>
<tr>
<td>UPDATE</td>
<td>PUT</td>
<td>/profile</td>
<td></td>
<td>UPDATE</td>
</tr>
<tr>
<td>DESTROY</td>
<td>DELETE</td>
<td>/profile</td>
<td></td>
<td>DELETE</td>
</tr>
</tbody></table>

#### Collections of Things
In the last example there's never an id provided to the server to tell it which
profile should be manipulated. In the previous case it's assumed there's only
one profile per user and the user's profile can be obtained via a cookie, session
or another authentication mechanic. Each user only has one profile.

Amazon has millions (billions?) of products. Products aren't associated 1:1
with users, they exist independently, yet they're all similar. RESTful routes
can add an `id` parameter to identify a unique element from an entire
collection. Study the table below to see how the `{id}` is parameterized into
the different route paths.

Notice the addition of the new INDEX route which returns a list of all objects
in the collection.

<table><thead>
<tr>
<th>Action</th>
<th>HTTP Method</th>
<th>Url Template</th>
<th>HTML form?</th>
<th>CRUD</th>
</tr>
</thead><tbody>
<tr>
<td>INDEX</td>
<td>GET</td>
<td>/products</td>
<td></td>
<td>Read</td>
</tr>
<tr>
<td>SHOW</td>
<td>GET</td>
<td>/products/{id}</td>
<td></td>
<td>Read</td>
</tr>
<tr>
<td>NEW</td>
<td>GET</td>
<td>/products/new</td>
<td>Yes</td>
<td></td>
</tr>
<tr>
<td>CREATE</td>
<td>POST</td>
<td>/products</td>
<td></td>
<td>Create</td>
</tr>
<tr>
<td>EDIT</td>
<td>GET</td>
<td>/products/{id}/edit</td>
<td>Yes</td>
<td></td>
</tr>
<tr>
<td>UPDATE</td>
<td>PUT</td>
<td>/products/{id}</td>
<td></td>
<td>Update</td>
</tr>
<tr>
<td>DESTROY</td>
<td>DELETE</td>
<td>/products/{id}</td>
<td></td>
<td>Destroy</td>
</tr>
</tbody></table>
