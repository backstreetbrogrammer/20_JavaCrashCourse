# Java Crash Course

> This is a Java Crash Course covering various Java topics, design patterns, performance tuning, interview problems
> and solutions and much more.

Tools used:

- JDK 11
- Maven
- JUnit 5, Mockito
- IntelliJ IDE

## Table of contents

### Module 1: Java Fundamentals Recap

1. Java Fundamentals
    - Data Types: Primitives, String
    - Variables, Expressions
    - Operators
    - Methods
    - Control Flow (for, while loops)
3. Object-Oriented Programming
    - Classes, Objects, Interfaces, Abstract Classes
    - Inheritance - method overloading and overriding
    - Polymorphism - composition and encapsulation
4. Arrays and Collections
    - Arrays
    - Arrays class utility
    - List, Set, Map
    - Comparable and Comparator
    - Collections class utility
5. Concurrency Basics
    - Threading fundamentals - creation and coordination
    - Thread pools
    - Concurrent Collections
    - Synchronization techniques - Locks and Conditions
6. Lambda and Streams
    - Lambda Expressions
    - Functional Interfaces
    - Streams, Parallel Streams

---

### Module 2: Advanced Java Topics

---

### Module 3: Test-Driven Development and Test Automation

---

### Module 4: Clean Code, Refactoring, and Design Patterns

---

### Module 5: Message Queues and Event-Driven Architecture

---

### Module 6: Microservices and Distributed Systems

---

### Module 7: DevOps and CI/CD Pipeline

---

### Module 1: Java Fundamentals Recap

#### Chapter 01. Java Fundamentals

##### Data Types: Primitives, String

![Primitives in Java](PrimitivesDataTypes.PNG)

The 8 primitive data types supported by the Java programming language are:

`byte`: The byte data type is an 8-bit signed two's complement integer. It has a minimum value of -128 and a maximum
value of 127 (inclusive).

`short`: The short data type is a 16-bit signed two's complement integer. It has a minimum value of -32,768 and a
maximum value of 32,767 (inclusive).

`int`: By default, the int data type is a 32-bit signed two's complement integer, which has a minimum value of -2^31 and
a maximum value of 2^31-1. In Java SE 8 and later, we can use the int data type to represent an unsigned 32-bit integer,
which has a minimum value of 0 and a maximum value of 2^32-1. Use the `Integer` class to use int data type as an
**unsigned integer**. Static methods like `compareUnsigned`, `divideUnsigned` etc. have been added to the `Integer`
class to support the arithmetic operations for unsigned integers.

`long`: The long data type is a 64-bit two's complement integer. The signed long has a minimum value of -2^63 and a
maximum value of 2^63-1. In Java SE 8 and later, we can use the long data type to represent an unsigned 64-bit long,
which has a minimum value of 0 and a maximum value of 2^64-1. The `Long` class also contains methods like
`compareUnsigned`, `divideUnsigned` etc. to support arithmetic operations for **unsigned long**.

`float`: The float data type is a single-precision 32-bit IEEE 754 floating point. This data type should never be used
for precise values, such as currency. For that, we will need to use the `java.math.BigDecimal` class instead.

`double`: The double data type is a double-precision 64-bit IEEE 754 floating point. For decimal values, this data type
is generally the default choice. As mentioned above, this data type should never be used for precise values, such as
currency.

`boolean`: The boolean data type has only two possible values: `true` and `false`. Use this data type for simple flags
that track true/false conditions. This data type represents one bit of information, but its "size" isn't something that'
s precisely defined.

`char`: The char data type is a single 16-bit Unicode character. It has a minimum value of '\u0000' (or 0) and a maximum
value of '\uffff' (or 65,535 inclusive).

In addition to the eight primitive data types listed above, the Java programming language also provides special support
for character strings via the `java.lang.String` class. Enclosing character string within double quotes will
automatically create a new `String` object.

For example,

```
String s = "this is a string";
```

String objects are **immutable**, which means that once created, their values cannot be changed. The String class is not
technically a primitive data type, but considering the special support given to it by the language, we'll probably tend
to think of it as such.

###### Interview Problem 1 (UBS): Is there any limit to the length of String we can create in Java ?

**Solution**:

`String` in Java is defined by array of characters: `char[]`. An array can have `int` values as index.

Thus, we should be able to get a String of length whichever is **smaller**:

1. Integer.MAX_VALUE always 2,147,483,647 (231 - 1)
   (Defined by the Java specification, the maximum size of an array, which the String class uses for internal storage)

**OR**

2. Half of allotted maximum heap size (since each character is 2 bytes).

###### Interview Problem 2: Using Underscore Characters in Numeric Literals

In Java SE 7 and later, any number of underscore characters (_) can appear anywhere between digits in a numerical
literal. This feature enables, for example, to separate groups of digits in numeric literals, which can improve the
readability of our code.

For ex:

```
long creditCardNumber = 1234_5678_9012_3456L;
float pi = 3.14_15F;
byte nybbles = 0b0010_0101;
```

Which of the following are **valid** and **invalid** underscore placements in numeric literals:

```
float pi1 = 3_.1415F;

int x1 = 5_2;

float pi2 = 3._1415F;

long socialSecurityNumber1 = 999_99_9999_L;

int x2 = 52_;

int x3 = 5_______2;

int x5 = 0x_52;

int x6 = 0x5_2;
```

**Solution**:

```
float pi1 = 3_.1415F; // Invalid: cannot put underscores adjacent to a decimal point

int x1 = 5_2; // Valid

float pi2 = 3._1415F; // Invalid: cannot put underscores adjacent to a decimal point

long socialSecurityNumber1 = 999_99_9999_L; // Invalid: cannot put underscores prior to an L suffix

int x2 = 52_; // Invalid: cannot put underscores at the end of a literal

int x3 = 5_______2; // Valid

int x5 = 0x_52; // Invalid: cannot put underscores at the beginning of a number 

int x6 = 0x5_2; // Valid
```

###### Interview Problem 3 (CLSA): Compute the parity of a `long`.

The **parity** of a binary word (64-bit) is **1** if the number of 1s in the word is **odd**; otherwise, it is **0**.
For example, the parity of 1011 is 1, and the parity of 10001000 is 0. Parity checks are used to detect single bit 
errors in data storage and communications. 

**Solution**:

```java
    // Time complexity: O(n) ~ n is 64-bit length, i.e. 64
    public static short parity(long word) {
        short result = 0;
        while (word != 0L) {
            result ^= (word & 1);
            word >>>= 1;
        }
        return result;
    }
```

Slightly optimised solution:

```java
    // Time complexity: O(k) ~ k is no of set bits (1) in word
    public static short parityOptimised(long word) {
        short result = 0;
        while (word != 0L) {
            result ^= 1;
            word &= (word - 1); // drops the lowest set bit (1) of word
        }
        return result;
    }
```


##### Statement and Expression

What is a **statement** and an **expression** in Java?

In Java, a **statement** is an executable instruction that tells the compiler what to perform. It forms a complete
command to be executed and can include one or more **expressions**.

An **expression** is any valid unit of code that resolves to a value. Conceptually, there are two types of expressions:
those that assign a value to a variable and those that simply have a value.

![Statement and Expression](JShell_Statement.PNG)

For example:

```
// this whole line is a statement
System.out.print("Hello Students!!");

// this is an expression having a String value and it can be assigned to a variable
"Hello Students!!" 
```

