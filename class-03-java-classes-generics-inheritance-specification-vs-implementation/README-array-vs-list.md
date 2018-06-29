# ![CF](http://i.imgur.com/7v5ASc8.png) Arrays vs Lists

## Resources  
* [How to implement an ArrayList](http://www.vogella.com/tutorials/JavaDatastructureList/article.html)
* [Wikipedia: List ADT (Abstract Data Type)](https://en.wikipedia.org/wiki/List_(abstract_data_type))

## Learning Objectives
* Understand there's a difference in programming between `Arrays` and `Lists`.
* Create an ArrayList by wrapping an array in a class and manually manipulating
  its state.

### Arrays Are Fixed-Size
Unlike JavaScript, arrays in Java have a fixed size. When you create an array
you have to declare how large it will be. Once it's declared the size never,
ever, changes. This means if you create an array of size `10` it can only
hold up to ten things. You can **never** change the size of an array in Java.
In order to "add more things" Java forcses us to create an entirely new array
and elements from the old array into the new array.

Fortunately, we can create our own class that encapsulates this behavior. We
can create an `ArrayList` that uses fixed-size arrays and makes them appear
to easily grow and shrink by exposing easy-to-use methods like `.add()` and
`.remove()`. Let's see what it takes to create malleable lists out of rigid,
fixed-size arrays.

### The ArrayList
Our `ArrayList` class will create it's own internal fixed-size array and create
methods that allow users to manipulate the array as if it were a stretchy,
growing, shrinking, JavaScript-like array.

Our ArrayList class will store it's array internally, and store one variable
`size` or `index` that keeps track of how full the array is.

Here's what the internal state of our ArrayList will look like as it's first
created, and things are added to it.

```
MyArrayList list = new MyArrayList();
list.add("foo");
list.add("bar");
list.remove("bar");
```

* The array starts with some fixed size and everything in the array is null.
* The size starts at 0.
* When elements are added to the list they're added at the end of the list,
  according to the value of the size parameter.
* The value of size goes up by one every time an element is added.
* The value of size goes down by one every time an element is removed.
* Notice that even though "bar" was removed it's still in the array.
  It's enough to decrement the size variable to show that the list
  doesn't cover that area of the array anymore.

```
size = 0
[null, null, null, null]

size = 1
["foo", null, null, null]

size = 2
["foo", "bar", null, null]

size = 1
["foo", "bar", null, null]
```

Consider what happens when a value in the front is removed. It would be strange
to have `null` sitting at the front of the list. If we removed things all over
the place and simply replaced them with `null` the array would have "holes" of
null data all througout it.

Any time an element is removed we must shift over every other value to fill
the spot it left.

```
size = 4
["foo", "bar", "baz", "car"]

size = 3
[null, "bar", "baz", "car"]   // BAD

size = 3
["bar", "baz", "car", "car"]   // GOOD
```

Similarly, if you ever adding an element in the middle of the array we must
shift every element over one to make room for the new element, then set it
in the array.

If the array ever fills all the way up we can make it continue to grow by
creating a new array twice the size of the previous array and copying all
the values into it.

### Specification vs Implementation
A specification defines how a program, or piece of a program, should behave.
An implementation is the manifestation of a specification. There can be many
different implementations of one specification. Consider cars.

The idea of a "car" could be considered a specification. Every car has certain
things it should be able to do. Any car should be able to turn on, turn off,
drive, turn, accelerate, brake, and those sorts of things.

An implementation of the idea of a "car" would be any physical car. Notice
there's many different vendors: Toyota, Ford, Dodge, BMW, and etc. Each vendor
builds their cars slightly differently, yet each of their implementations
satisfies the overall "car" specification.

Programming is the same as cars. There are general ideas of things, like
a "list," and there are implementations people have made that turn the
idea of a "list" into something we can actually use.

Drawing a distinction between specifications and implementations offers
advantages to us as programmers. Specifications allow us to agree how something
should behave without having to know anything about how it's implemented. If we
know something is a list we can simply treat it like a list.

Consider cars again. What's the difference between driving an electric car
or a gas-powered car? They're both cars. If it drives, that's good enough for
me! We don't need to concern ourselves with how the engine is built, or what
type of engine it is. It's under the hood.

But sometimes it's good to know what's under the hood! Sometimes you need
something more than just any "car." Sometimes you need a truck, or a van, or
you care about having an electric car, or you're concerned about the efficiency
of an engine because you'll drive it a lot. That's great. If you ever know you
want or need something more than simply a car then you can specify what sort of
car you need and make sure to buy that one specifically.

Furthermore, if you ever get specific and buy exactly the certain type of car
that you want then once you take it back home you can interact with it as
simply a car again. Even if you buy a fancy car, or a customized car, or
make choices about what specific type of car you want, at the end of the day
you can treat it simply like a car.

This all is the essence behind this code:

```java
List<String> list = new ArrayList<>();
```

The specification here is `List`. The implementation is `ArrayList`. There
are several implementations of the `List` specification. Here we're choosing
one and creating it with it's constructor `new ArrayList<>()` and then we're
saying the type of it is just `List` because when we use it it doesn't matter
that the implementation is an ArrayList. It's sufficient to treat it just like
a List.

Here's the advantage this gives us as programmers. Using specifications like
`List`, or anything else, allows us to write programs that interact with all
List-like things. You can declare a method that accepts `List` as a parameter
and then that method can interact with any implementation that satisfies
what it means to be a List.

```java
List<String> l1 = new ArrayList<>();
List<String> l2 = new LinkedList<>();
List<String> l3 = new FictionalFuturisticListImplementationFrom3017();

public static boolean contains(List<String> haystack, String needle) {
  for (int i = 0; i < haystack.size(); i++) {
    if (haystack.get(i).equals(needle)) {
      return true;
    }
  }
  return false;
}
```
