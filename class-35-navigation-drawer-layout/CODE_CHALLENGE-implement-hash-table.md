# Hash Tables
* [Wikipedia: Hash Table](https://en.wikipedia.org/wiki/Hash_table)

Hash Tables are an incredibly efficient data structure that store key/value
pairs. They offer O(1) time complexity for these operations:

* O(1) - create
* O(1) - read
* O(1) - update
* O(1) - remove

It's true!

Hash Tables store key-value pairs in an array. Consider how you could do this
naively. Create a class called `KeyValuePair` that simply stores a key and
a value. We could create an array that keeps track of many of these.

```java
public class KeyValuePair<K, V> {
  public K key;
  public V value;
}
```

We could use a `List` to store there. Here we'll use Seattle neighborhood names
as keys, and their zip codes as values.

```java
KeyValuePair pioneerSquare = new KeyValuePair("Pioneer Square", 98104);
KeyValuePair uDistrict = new KeyValuePair("University District", 98105);
KeyValuePair downtown = new KeyValuePair("Downtown", 98101);

List<KeyValuePair> neighborhoods = new ArrayList<>();
neighborhoods.add(pioneerSquare);
neighborhoods.add(uDistrict);
neighborhoods.add(downtown);
```
Now that these values are in an array let's write a function that returns the
value associated with a key.

```java
// slow O(N) lookup looking 1 by 1 through whole array
public V get(K key) {
  for (KeyValuePair kv : neighborhoods) {
    if (kv.key.equals(key)) {
      return kv.value;
    }
  }

  // no match found
  return null;
}
```

```java
// super fast O(1) lookup using hash function
public V getUsingHash(K key) {
  // use any valid hash function
  int hashCode = hash(key);

  // convert the hashCode to a valid array index
  int index = hashCode % neighborhoods.size();

  // access that index directly.
  return neighborhoods.get(index);
}
```

This totally works to store KeyValuePair objects, and we can search pairs by
giving just their key. The problem with this approach is it takes O(N) time
to look through the whole array to see if the key exists in the list.

We can do better.

# The Hash Code
The ingenuity of Hash Tables lies in the idea of a `hash code`. A hash code is
a function that takes a key (any key) and converts the key into an integer.

The hash table computes the hash code for the key, then treats that hash code
as an index into the array. If the hash code is larger than the length of the
array it simply uses the modulus operator to restrict the hash code to the
bounds of the length of the array.

If a key hashses to 3831 and the array is only of size 100 then 3831 modulus
100 equals 31 and the hash table looks at index 31.

Hash code properties:
* The hash code function must always return the same hash code when it's given
  the same key.
* If a hash code function produces different hash codes for the same key then
  it's entirely useless.

How do you turn a key into a hash code?

Suppose a key is a string. Here are two simple hash codes:

* Take the ASCII value of every letter and sum them all together.
* Take the ASCII value of every letter and multiply them all together.

In reality researchers spend a lot of time studying hash codes to find out what
produces a good result. We will use these two sum and multiplication hash codes
just in order to understand how hash tables work. In reality most people use
hash codes provided by their programming language or a library.

The efficiency of hash tables comes from the fact that you can turn a key into
a hash code and use that to look at exactly one specific index into the array.
Instead of looking through the entire array to see if the array contains your
key you can compute the hash code, look at that index, and see if your
`KeyValuePair` object is there.

Even if an array has one billion elements a consistent hash code function
allows you to function the _exact_ index where a `KeyValuePair` will be. This
is how hash tables achieve O(1) efficiency for all their operations.

![hash table](./hash_table.png)

# Collisions
It's possible two different keys may generate the same hash code. This would
mean two different keys may collide and overwrite each other's values when
they're added to the map!

Hash Tables solve this problem in one of two ways:

* Probing (linear or quadratic)
* Buckets (Linked Lists)

## Probing
*Probing* just means that if a hash code leads to a spot in the array where
a KeyValuePair already exists then it "probes" looking for another spot. The
Hash Table begins looking at the array where the hash code says. If there's
something there then it looks next to it. If there's something in that spot,
then it looks at the next spot after that. And it continues until it finds an
empty spot.

Linear probing:
* Looks at the index of the hash code to see if it's full
* Looks N steps away
* Looks N * 2 steps away
* Looks N * 3 steps away
* Looks N * 4 steps away
* And so on until it finds an empty spot in the array.

Quadratic probing:
* Looks at the index of the hash code to see if it's full
* Looks N steps away
* Looks N + 2^2 steps away
* Looks N + 3^2 steps away
* Looks N + 4^2 steps away
* Looks N + 5^2 steps away
* And so on until it finds an empty spot in the array.

Linear probing looks linearly through the array at an even pace, whereas
quadratic probing will look through the array at a more uneven pace. Quadratic
probing is said to spread values out throughout the array better than linear
probing.

* [Wikipedia: Linear Probing](https://en.wikipedia.org/wiki/Linear_probing)
* [Wikipedia: Quadratic Probing](https://en.wikipedia.org/wiki/Quadratic_probing)

## Buckets (with LinkedLists)
Another approach avoids probing entirely. Instead of searching for an empty
spot in the array the Hash Table stores a reference to a LinkedList at every
index. Whenever a KeyValuePair is added to that spot in the array the
KeyValuePair is appended to the end of the LinkedList.

When a key is given to look something up the Hash Table hashes the key, then
iterates through the Linked List stored at that index until it finds
a KeyValuePair with a matching key.

Remember: it's important to store BOTH the value AND the key in the hash table.
If you only store keys then it will be impossible to tell what value is
associated with what key when you're looking up something that had a collision.

# Really O(1)?
An aside: yes, since there are collisions hash tables aren't quite precisely
O(1) operations. You could get extra technical and say they have a Big-O
complexity related to the time it takes to compute the hash. Also, you could
say they have a O(N) lookup time in the case that every item added to the table
collided to the same value and you had to look through all the elements
anyways.

Still, most everyone assumes you have a sane hash code and sane conditions.
Read up on it and you'll find people generally agree all hash table operations
are O(1).


# Implement Hash Table
Implement a hash table using an array of fixed size when it's created.
Parameterize the constructor so the user can choose the size of the
array to begin with. Provide a default constructor that creates an array
of size `10`.

Configure your hash map to work with Strings initially.

Define a custom `.hash(String ss)` method that accepts a String and returns
an int. Use the int to choose an index in the fixed-size array.

Store a Linked List at each index of the array to be used for collisions.
Whenever a value is added at an index simply append it to the Linked List,
and store both the Key and the Value in the list so you can look up the
Value by it's key later.

# Stretch Goals
Configure your HashMap with Java Generics so it can associate any type of
Key and Value.

```
ADD HASHED: Pioneer Square= 1379
ADD HASHED: Alki Beach= 884
ADD HASHED: U District= 955

ADD INDEX: Pioneer Square= 92
ADD INDEX: Alki Beach= 92
ADD INDEX: U District= 64
```

```
MULT HASHED: Pioneer Square= 599126016
MULT HASHED: Alki Beach= 1062823936
MULT HASHED: U District= 578867200

MULT INDEX: Pioneer Square= 93
MULT INDEX: Alki Beach= 31
MULT INDEX: U District= 43
```

```
Bucket 0: []
Bucket 1: []
Bucket 2: []
Bucket 3: []
Bucket 4: []
Bucket 5: []
Bucket 6: []
Bucket 7: []
Bucket 8: []
Bucket 9: []
Bucket 10: []
Bucket 11: []
Bucket 12: [{South Lake Union->98109}]
Bucket 13: [{Madrona->98110}]
Bucket 14: []
Bucket 15: []
Bucket 16: [{Magnolia->98199}]
Bucket 17: []
Bucket 18: []
Bucket 19: [{Greenlake->98103}]
Bucket 20: [{Redmond->98052}]
Bucket 21: []
Bucket 22: []
Bucket 23: []
Bucket 24: [{Kirkland->98033}]
Bucket 25: []
Bucket 26: []
Bucket 27: []
Bucket 28: [{Bellevue->98005}]
Bucket 29: [{Seattle->98101}]
Bucket 30: []
Bucket 31: []
Bucket 32: []
Bucket 33: []
Bucket 34: []
Bucket 35: []
Bucket 36: [{Renton->98055}]
Bucket 37: [{Queen Anne->98109}]
Bucket 38: [{Capital Hill->98102}]
Bucket 39: []
Bucket 40: [{Freemont->98103}]
Bucket 41: []
Bucket 42: []
Bucket 43: []
Bucket 44: []
Bucket 45: []
Bucket 46: []
Bucket 47: [{Greenwood->98103},{Belltown->98121}]
Bucket 48: []
Bucket 49: [{Northgate->98125}]
Bucket 50: [{Bainbridge Island->98110}]
Bucket 51: []
Bucket 52: []
Bucket 53: [{Mercer Island->98040}]
Bucket 54: []
Bucket 55: []
Bucket 56: []
Bucket 57: []
Bucket 58: [{Mount Baker->98144}]
Bucket 59: []
Bucket 60: [{International District->98104}]
Bucket 61: []
Bucket 62: []
Bucket 63: []
Bucket 64: []
Bucket 65: [{Columbia City->98118}]
Bucket 66: [{Lynnwood->98037}]
Bucket 67: []
Bucket 68: []
Bucket 69: []
Bucket 70: []
Bucket 71: []
Bucket 72: [{Downtown->98101}]
Bucket 73: []
Bucket 74: []
Bucket 75: []
Bucket 76: []
Bucket 77: []
Bucket 78: []
Bucket 79: [{University District->98105}]
Bucket 80: []
Bucket 81: []
Bucket 82: []
Bucket 83: []
Bucket 84: [{West Seattle->98116}]
Bucket 85: []
Bucket 86: []
Bucket 87: []
Bucket 88: []
Bucket 89: []
Bucket 90: [{Laurelhurst->98105}]
Bucket 91: []
Bucket 92: [{Pioneer Square->98104},{Alki Beach->98116}]
Bucket 93: []
Bucket 94: []
Bucket 95: []
Bucket 96: [{Ballard->98107}]
Bucket 97: []
Bucket 98: []
```

```
Bucket 0: [{Renton->98055},{Capital Hill->98102},{Greenwood->98103},{Greenlake->98103},{Pioneer Square->98104},{University District->98105},{Columbia City->98118}]
Bucket 1: [{Bellevue->98005},{Seattle->98101}]
Bucket 2: [{Mercer Island->98040},{Alki Beach->98116},{Northgate->98125}]
Bucket 3: [{Downtown->98101},{Laurelhurst->98105},{Bainbridge Island->98110},{Magnolia->98199}]
Bucket 4: [{Kirkland->98033},{Lynnwood->98037},{Ballard->98107},{Queen Anne->98109},{West Seattle->98116}]
Bucket 5: [{International District->98104},{Mount Baker->98144}]
Bucket 6: [{Redmond->98052},{Freemont->98103},{South Lake Union->98109},{Madrona->98110},{Belltown->98121}]
```

