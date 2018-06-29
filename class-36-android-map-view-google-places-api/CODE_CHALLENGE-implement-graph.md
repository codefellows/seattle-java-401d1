# Implement a Graph
Create a class called `Graph` and implement a graph. A graph is similar to a
tree, but it imposes less rules. Trees only have branches that branch out from
the root, and trees may never contain cycles.

Graphs are a collection of nodes and edges connected to each other. Graphs
can have cycles. Graphs can place values on their edges, or the nodes, and
nodes don't necessary have to have edges that point back and forth to each
other; two nodes can have an edge that only points from one to another.

Consider Facebook friendships and Twitter accounts. Facebook friendships are a
two-way agreement. One person sends a friend request, another accepts or rejects
it. Once two people are friends their friendship extends within Facebook back
and forth. Two nodes have edges that point back and forth to each other.

Twitter is different. Twitter accounts can have asymmetrical relationships.
One account can follow another account without the second account following
the first account back. This is like two nodes having a one-way edge between
the two of themselves.

Graphs can be used to represent lots of interesting things!

Consider a city with streets and intersections. Intersections are nodes, streets
are edges. There can be two-way streets and one-way streets. It's possible to
go from one intersection down a one-way street to another without being able
to turn around and go back the same way. You can assign values (called "weights")
to streets to represent speed limits.

Implement your Graph with either a Map, or a 2D array.

Your Graph and node classes should have the following methods:
* `.getNode(String name)` - returns a node by it's identifying name.
* `node.getEdges()` - returns a list of edges leading out from this node.

Later we'll learn algorithms and write programs that interact with a Graph.
It's possible to do traversals to search for values, or to calculate the
shortest path between any two nodes, which is useful in applications like
Google Maps!
