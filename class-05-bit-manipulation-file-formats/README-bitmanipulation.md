# ![CF](http://i.imgur.com/7v5ASc8.png) Data Modeling and Binary Data

## Learning Objectives
* Students will learn how binary data is encoded and decoded
* Students will be able to manipulate binary data

## Resources
* Read [Java Bitwise Operator Docs](node buffer api docs)
* Read [Bitmap file format](https://en.wikipedia.org/wiki/BMP_file_format)
* Watch [endian and little endian](https://www.youtube.com/watch?v=B50mNoVw21k)

### JavaData Modeling
Java has a limited number of built in data types including ints, doubles, floats,
arrays, strings, and booleans. Data modeling in Java is the
process of taking a real world or conceptual idea and encoding it into
Java's built in data-types. There isn't technically a right or wrong way to
model data in software development, because it has been proven that any idea can
be represented using any data structure. However it is important to follow
several practices to boost software readability and maintainability. Booleans
should be used when the data can have only two states. Numbers should be used
when the data could support arithmetic operations. Strings should be used when
the data is representing natural language. Arrays should be used to bundle
multiple pieces of like data.

### Binary
You probably know that everything in the computer is stored in 0s and 1s. As web
developers we don't often have to work with data at such a low level, instead we
usually get to work with Strings, Numbers, Arrays, Objects, and so on. Though
most of the time we are lucky enough to work with such abstracted data types,
sometimes we are required to understand how data is stored in binary. There are
predefined specifications for how to decode number and strings from binary. The
majority of the data we work with is made up of numbers and strings. For example
Numbers and Strings are used to make more complex things like JSON, XML, HTML,
JPEG, GIF, MP3, MP4, and even Java. Understanding how to manipulate binary
data on a more fundamental level, can open up doors for having much more control
over the data in our applications.

#### Bytes
A byte is 8 zeros and ones `00101101`. Bytes are one of the fundamental units
that programmers use to work with binary data. A byte can hold one ascii
character, a number between 0 and 255, a number between -128 and 127, and
anything else that has up to 256 units.

#### Strings
Strings are made from arrays of characters. Every byte in a binary file can be
decoded as a character using the `ascii` or `utf8` character specifications. The
ASCII standard has been around since the early sixties, and was used to encode
characters of a single locale (language). It is literally a map between numbers
0 to 127 and specific characters. Meaning that when you find the number 97 in a
byte, that byte can also be decoded as the letter 'a'. This only works by making
computers and programmers conform to the specification. As computers gained more
memory and found reasons to support more character sets, the `utf8`
specification was created. UTF8 is a variable length byte encoding that allows
bytes to be chained together to form a  character set large enough to support
every locale, symbols, and emoji at once. UTF8 was designed as a superset of
ASCII in order keep backwards compatibility.  

###### ASCII Table
```
  0 nul    1 soh    2 stx    3 etx    4 eot    5 enq    6 ack    7 bel
  8 bs     9 ht    10 nl    11 vt    12 np    13 cr    14 so    15 si
 16 dle   17 dc1   18 dc2   19 dc3   20 dc4   21 nak   22 syn   23 etb
 24 can   25 em    26 sub   27 esc   28 fs    29 gs    30 rs    31 us
 32 sp    33  !    34  "    35  #    36  $    37  %    38  &    39  '
 40  (    41  )    42  *    43  +    44  ,    45  -    46  .    47  /
 48  0    49  1    50  2    51  3    52  4    53  5    54  6    55  7
 56  8    57  9    58  :    59  ;    60  <    61  =    62  >    63  ?
 64  @    65  A    66  B    67  C    68  D    69  E    70  F    71  G
 72  H    73  I    74  J    75  K    76  L    77  M    78  N    79  O
 80  P    81  Q    82  R    83  S    84  T    85  U    86  V    87  W
 88  X    89  Y    90  Z    91  [    92  \    93  ]    94  ^    95  _
 96  `    97  a    98  b    99  c   100  d   101  e   102  f   103  g
104  h   105  i   106  j   107  k   108  l   109  m   110  n   111  o
112  p   113  q   114  r   115  s   116  t   117  u   118  v   119  w
120  x   121  y   122  z   123  {   124  |   125  }   126  ~   127 del
```

#### Integers
In order to understand how integers are encoded in zeros and ones, its important
to understand how decimal notation works. In decimal every digit is worth it
self times ten to the power of its place. In binary this only changes slightly,
every digit is worth it self times **TWO** to the power of its place. Integers
can either be decoded as `signed` or `unsigned`. Signed numbers can be negative
or positive, and unsigned numbers can only be positive.

```
HOW DECMAL WORKS...

places    43210
_______________
value     06974

6974 base 10 is the same as (6 * 10^3) + (9 * 10^2) + (7 * 10^1) + (8 * 10^0)
6974 base 10 is the same as (6 * 1000) + (9 * 100) + (7 * 10) + (8 * 1)
6974 base 10 is the same as (6000) + (900) + (70) + (8)
6974 base 10 is the same as 6974

----------------------------------------------------------------------

HOW UNSIGNED BINARY WORKS

places    43210
_______________
value     01011

1010 base 2 is the same as (1 * 2^3) + (0 * 2^2) + (1 * 2^1) + (1 * 2^0)
1010 base 2 is the same as (1 * 8) + (0 * 4) + (1 * 2) + (1 * 1)
1010 base 2 is the same as (8) + (0) + (2) + (1)
1010 base 2 is the same as 11
```

###### Signed vs Unsigned
Signed integers add a rule that states the first bit represents whether or not a
numbers is positive or negative. Negative values then follow a rule called `twos
complement`. In twos complement the value after the singed bit is added to the
number of positions supported by the the remaining bits and then multiplied by
-1. When decoding a four bit signed number the first bit is a boolean value
indicating negative or positive. The remaining three can support 8 unique values
(0-7). So a signed four bit number can represent positive numbers from 0 to 7 and
negative numbers -1 to -8.

```
Signed |Unsigned
-----------------.
 0     |0        |0000
 1     |1        |0001   
 2     |2        |0010   
 3     |3        |0011   
 4     |4        |0100   
 5     |5        |0101   
 6     |6        |0110   
 7     |7        |0111   _________NEGATIVE_VALUES
-8     |8        |1000   (8 + 0) * -1
-7     |9        |1001   (8 + 1) * -1
-6     |10       |1010   (8 + 2) * -1
-5     |11       |1011   (8 + 3) * -1
-4     |12       |1100   (8 + 4) * -1
-3     |13       |1101   (8 + 5) * -1
-2     |14       |1110   (8 + 6) * -1
-1     |15       |1111   (8 + 7) * -1
```

###### Hex Cheat Sheet
Sometimes we want to look at data more succinctly than seeing it expanded with
all the ones and zeros. We can represent binary numbers with hexadecimal
numbers. Hexadecimal is a base-16 number system (binary is base-2, we normally
use base-10). Hexadecimal allows us to use the numerals `0-9` and the letters
`a-f` to represent the numbers 0-16.

`10` in hexadecimal represents the value 16.

Look at the chart below to see how to write number values in three different
bases:

* decimal (base-10)
* hexadecimal (base-16)
* binary (base-2)

``` text
DEC |HEX |BIN
--------------
0   |00   |00000
1   |01   |00001   
2   |02   |00010   
3   |03   |00011   
4   |04   |00100   
5   |05   |00101   
6   |06   |00110   
7   |07   |00111   
8   |08   |01000   
9   |09   |01001   
10  |0a   |01010   
11  |0b   |01011   
12  |0c   |01100   
13  |0d   |01101   
14  |0e   |01110   
15  |0f   |01111   
16  |10   |10000
17  |11   |10001
18  |12   |10010
...
29  |1d   |011101
30  |1e   |011110
31  |1f   |011111
32  |20   |100000
```
