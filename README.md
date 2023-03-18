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
    - Operators
    - Statements, Expressions and Code Blocks
    - Methods
    - Control Flow
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
which has a minimum value of 0 and a maximum value of 2^32-1.

`long`: The long data type is a 64-bit two's complement integer. The signed long has a minimum value of -2^63 and a
maximum value of 2^63-1. In Java SE 8 and later, we can use the long data type to represent an unsigned 64-bit long,
which has a minimum value of 0 and a maximum value of 2^64-1.

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

1. Integer.MAX_VALUE always 2,147,483,647 (2^31 - 1)
   (Defined by the Java specification, the maximum size of an array, which the String class uses for internal storage)

**OR**

2. Half of allotted maximum heap size (since each character is 2 bytes).

##### Operators

Operators are special symbols that perform specific operations on one, two, or three operands, and then return a result.

![Operators](Operators.PNG)

They are classified based on the functionality they provide. Some types are:

- **Unary Operators**: Unary operators need only one operand. They are used to incrementing, decrement or negate a
  value.
    - Unary minus `–`, used for negating the values
    - Unary plus `+`, indicates the positive value (numbers are positive without this, however). It performs an
      automatic conversion to `int` when the type of its operand is the `byte`, `char`, or `short`. This is called unary
      numeric promotion.
    - Increment operator `++`, used for incrementing the value by 1. There are two varieties of increment operators:
        - Post-Increment: Value is first used for computing the result and then incremented
        - Pre-Increment: Value is incremented first, and then the result is computed
    - Decrement operator `--`, used for decrementing the value by 1. There are two varieties of decrement operators:
        - Post-decrement: Value is first used for computing the result and then decremented
        - Pre-Decrement: Value is decremented first, and then the result is computed
    - Logical **not** operator `!`, used for inverting a boolean value

- **Arithmetic Operators**: They are used to performing simple arithmetic operations on primitive data types.
    - Addition `+`
    - Subtraction `-`
    - Multiplication `*`
    - Division `/`
    - Modulo `%`

- **Relational Operators**: These operators are used to check for relations like equality, greater than, less than and
  return boolean results after the comparison.
    - Equal to `==`, returns true if the left-hand side is equal to the right-hand side.
    - Not Equal to `!=`, returns true if the left-hand side is not equal to the right-hand side.
    - Less than `<`, returns true if the left-hand side is less than the right-hand side.
    - Less than or equal to `<=`, returns true if the left-hand side is less than or equal to the right-hand side.
    - Greater than `>`, returns true if the left-hand side is greater than the right-hand side.
    - Greater than or equal to `>=`, returns true if the left-hand side is greater than or equal to the right-hand side.

- **Logical Operators**: These operators are used to perform “logical AND” and “logical OR” operations, i.e., a function
  similar to AND gate and OR gate in digital electronics. One thing to keep in mind is the second condition is not
  evaluated if the first one is false, i.e., it has a short-circuiting effect.
    - Logical AND `&&`, returns true when both conditions are true.
    - Logical OR `||`, returns true if at least one condition is true.
    - Logical NOT `!`, returns true when a condition is false and vice-versa

- **Bitwise Operators**: These operators are used to perform the manipulation of individual bits of a number.
    - Bitwise AND operator `&`, returns bit by bit AND of input values.
    - Bitwise OR operator `|`, returns bit by bit OR of input values.
    - Bitwise XOR operator `^`, returns bit-by-bit XOR of input values.
    - Bitwise Complement Operator `~`, This is a unary operator which returns the one’s complement representation of the
      input value, i.e., with all bits inverted.

- **Shift Operators**: These operators are used to shift the bits of a number left or right, thereby multiplying or
  dividing the number by two, respectively.
    - Left shift operator `<<`, shifts the bits of the number to the left and fills 0 on voids left as a result. Similar
      effect as multiplying the number with some power of two.
    - Signed Right shift operator `>>`, shifts the bits of the number to the right and fills 0 on voids left as a
      result. The leftmost bit depends on the sign of the initial number. Similar effect as dividing the number with
      some power of two.
    - Unsigned Right shift operator `>>>`, shifts the bits of the number to the right and fills 0 on voids left as a
      result. The leftmost bit is set to 0.

- **Assignment Operator**: This is used to assigning a value to any variable. It has a right to left associativity, i.e.
  value given on the right-hand side of the operator is assigned to the variable on the left, and therefore right-hand
  side value must be declared before using it or should be a constant. In many cases, the assignment operator can be
  combined with other operators to build a shorter version of the statement called a Compound Statement. This also helps
  to avoid any explicit casting. For example, instead of `a = a+5`, we can write `a += 5`.
    - Compound Addition `+=`, for adding left operand with right operand and then assigning it to the variable on the
      left.
    - Compound Subtraction `-=`, for subtracting right operand from left operand and then assigning it to the variable
      on the left.
    - Compound Multiplication `*=`, for multiplying left operand with right operand and then assigning it to the
      variable on the left.
    - Compound Division `/=`, for dividing left operand by right operand and then assigning it to the variable on the
      left.
    - Compound Modulo `%=`, for assigning modulo of left operand by right operand and then assigning it to the variable
      on the left.

- **Ternary Operator**: This is a shorthand version of the `if-else` statement. It has three operands and hence the name
  ternary. The general format is: `condition ? if true : if false`

- **`instanceof` Operator**: This is used for type checking. It can be used to test if an object is an instance of a
  class, a subclass, or an interface. The general format is: `object instanceof class/subclass/interface`

One of the most important things to consider is **operators precedence** used for evaluation of an expression.

![Operator Precedence](OperatorPrecedence.PNG)

Best practice is to use parenthesis `()` to change the precedence and make the code more readable.

###### Interview Problem 2 (CLSA): Compute the parity of a `long` word (64-bits).

The **parity** of a binary word (64-bit) is **1** if the number of 1s in the word is **odd**; otherwise, it is **0**.
For example, the parity of 1011 is 1, and the parity of 10001000 is 0. Parity checks are used to detect single bit
errors in data storage and communications.

**Solution**:

```java
public class ComputeParity {

    public static short parityUsingApi(final long word) {
        final int bitCount = Long.bitCount(word);
        return (short) ((bitCount % 2 == 0) ? 0 : 1);
    }

    // Time complexity: O(n) ~ n is 64-bit length, i.e. 64
    public static short parity(long word) {
        short result = 0;
        while (word != 0L) {
            result ^= (word & 1);
            word >>>= 1;
        }
        return result;
    }

    // Time complexity: O(k) ~ k is no of set bits (1) in word
    public static short parityOptimised(long word) {
        short result = 0;
        while (word != 0L) {
            result ^= 1;
            word &= (word - 1); // drops the lowest set bit (1) of word
        }
        return result;
    }

}
```

**Unit Test**:

```java
import org.junit.jupiter.api.Test;

public class ComputeParityTest {

    @Test
    void testParity() {
        final long[] nums = new long[]{5L, -8L, 17L, 999L, 1L};
        for (final long num : nums) {
            System.out.printf("Num=[%d], Binary=[%s], BitCount=[%d], [parityUsingApi=%d], [parity=%d], [parityOptimised=%d]%n",
                              num,
                              Long.toBinaryString(num),
                              Long.bitCount(num),
                              ComputeParity.parityUsingApi(num),
                              ComputeParity.parity(num),
                              ComputeParity.parityOptimised(num));
        }
    }

}
```

**Output**:

```
Num=[5], Binary=[101], BitCount=[2], [parityUsingApi=0], [parity=0], [parityOptimised=0]
Num=[-8], Binary=[1111111111111111111111111111111111111111111111111111111111111000], BitCount=[61], [parityUsingApi=1], [parity=1], [parityOptimised=1]
Num=[17], Binary=[10001], BitCount=[2], [parityUsingApi=0], [parity=0], [parityOptimised=0]
Num=[999], Binary=[1111100111], BitCount=[8], [parityUsingApi=0], [parity=0], [parityOptimised=0]
Num=[1], Binary=[1], BitCount=[1], [parityUsingApi=1], [parity=1], [parityOptimised=1]
```

##### Statements, Expressions and Code Blocks

###### What is a **statement** and an **expression** in Java?

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

###### Java Language Keywords

Here is a list of **keywords** in the Java programming language. We cannot use any of the following as identifiers in
our programs. The keywords `const` and `goto` are reserved, even though they are not currently used. `true`, `false`,
and `null` might seem like keywords, but they are actually literals; we cannot use them as identifiers in our programs.

![Java Language Keywords](Keywords.PNG)

###### Java Code Blocks

Writing code is similar to writing a document. It consists of special hierarchical units which together form a whole.

These are:

- **Expression**: An expression computes to a single value
- **Statement**: Statements are stand-alone units of work
- **Code Blocks**: A code block is a set of zero, one, or more statements, usually grouped together in some way to
  achieve a single goal

**Local Variable**: available for use by the code block in which it is declared. It is also available to code blocks
that are contained by a declaring block.

**Scope**: describes the accessibility of a variable:

- "In scope" means the variable can be used in the code block
- "Out of scope" means the variable is no longer avaiable in the code block

**Best practice**:

- declare and initialize variables in the same place if possible
- declare variables in the narrowest scope possible

###### The if-then and if-then-else Statements

The `if-then` statement is the most basic of all the control flow statements. It tells our program to execute a certain
section of code only if a particular test evaluates to `true`.

The `if-then-else` statement provides a secondary path of execution when an "if" clause evaluates to `false`.

![If-Then-Else](IfElse.PNG)

##### Methods

A method is a block of code which only runs when it is called. We can pass data, known as parameters, into a method.
Methods are used to perform certain actions, and they are also known as functions.

**Parameter** is the definition as shown in the method declaration, and the **argument** is the value that is passed to
the method when we call it.

Why use methods?

To reuse code: define the code once, and use it many times.

A method consists of six parts:

- **Access modifier**: `public, protected, private, default (package-private) and static` => optionally we can specify
  from wherein the code one can access the method
- **Return type**: the type of the value returned by the method, if any => a method can return a primitive value or an
  object reference, or it can return nothing if we use the `void` keyword as the return type
- **Method identifier**: the name we give to the method
- **Parameter list**: an optional comma-separated list of inputs for the method => can have anywhere from 0 to 255
  parameters that are delimited by commas
- **Exception list**: an optional list of exceptions the method can throw
- **Body**: definition of the logic (can be empty)

![Methods](Methods.PNG)

###### Method Overloading

Method Overloading allows different methods to have the same name, but different signatures where the signature can
differ by the number of input parameters or type of input parameters, or a mixture of both.

Method overloading is also known as Compile-time Polymorphism, Static Polymorphism, or Early binding in Java.

Different Ways of Method Overloading in Java:

- Changing the Number of Parameters.
- Changing Data Types of the Arguments.
- Changing the Order of the Parameters of Methods

###### Exceptions and Errors

**Exception** is an unwanted or unexpected event, which occurs during the execution of a program, i.e. at run time, that
disrupts the normal flow of the program’s instructions. Exceptions can be caught and handled by the program. When an
exception occurs within a method, it creates an object. This object is called the exception object. It contains
information about the exception, such as the name and description of the exception and the state of the program when the
exception occurred.

There are 2 types of built-in Exceptions:

- **Checked Exceptions**: Checked exceptions are called compile-time exceptions because these exceptions are checked at
  compile-time by the compiler.
- **Unchecked Exceptions**: The unchecked exceptions are just opposite to the checked exceptions. The compiler will not
  check these exceptions at compile time. In simple words, if a program throws an unchecked exception, and even if we
  did not handle or declare it, the program would not give a compilation error.

**Errors** represent irrecoverable conditions such as Java virtual machine (JVM) running out of memory, memory leaks,
stack overflow errors, library incompatibility, infinite recursion, etc. Errors are usually beyond the control of the
programmer, and we should not try to handle errors.

Use **try-catch-finally** to handle Exceptions:

![try-catch-finally](tryCatch.PNG)

##### Control Flow

The statements inside our source files are generally executed from top to bottom, in the order that they appear. Control
flow statements, however, break up the flow of execution by employing decision-making statements (`if-then`,
`if-then-else`, `switch`), looping statements (`for`, `while`, `do-while`), and branching statements (`break`,
`continue`, `return`), enabling our program to conditionally execute particular blocks of code.

###### The `switch` statement

The `switch` statement is a multi-way branch statement. In simple words, the `switch` statement executes one statement
from multiple conditions. It is like an `if-else-if` ladder statement. It provides an easy way to dispatch execution to
different parts of code based on the value of the expression. It basically tests the equality of variables against
multiple values.

![switch statement](switch.PNG)

A `switch` works with the `byte`, `short`, `char`, and `int` primitive data types. It also works with enumerated types
(`Enum` Types), the `String` class, and Wrapper classes: `Character`, `Byte`, `Short`, and `Integer`.

Some important rules for `switch` statements:

- There can be any number of cases just imposing condition check but remember duplicate case/s values are not allowed.
- The value for a case must be of the same data type as the variable in the switch.
- The value for a case must be constant or literal. **Variables** are not allowed.
- The `break` statement is used inside the switch to terminate a statement sequence.
- The `break` statement is optional. If omitted, execution will continue on into the next case.
- The `default` statement is optional and can appear anywhere inside the switch block. In case, if it is not at the end,
  then a break statement must be kept after the default statement to omit the execution of the next case statement.

###### The `for` statement

Loops in Java come into use when we need to repeatedly execute a block of statements.

The `for` statement provides a compact way to iterate over a range of values. Programmers often refer to it as the "for
loop" because of the way in which it repeatedly loops until a particular condition is satisfied.

The general form of the `for` statement can be expressed as follows:

![for loop](forLoop.PNG)

When using this version of the for statement, keep in mind that:

- The initialization expression initializes the loop; it's executed once, as the loop begins.
- When the termination expression evaluates to `false`, the loop terminates.
- The increment expression is invoked after each iteration through the loop; it is perfectly acceptable for this
  expression to increment or decrement a value.

The `for` statement also has another form designed for iteration through `Collections` and `arrays`. This form is
sometimes referred to as the `enhanced for statement`, and can be used to make our loops more compact and easy to read.

Syntax:

![enhanced for](enhancedFor.PNG)

###### The `while` and `do-while` statements

The `while` statement continually executes a block of statements while a particular condition is `true`. Its syntax can
be expressed as:

```
while (expression) { 
    statement(s)
} 
```

The `while` statement evaluates expression, which must return a boolean value. If the expression evaluates to `true`,
the `while` statement executes the statement(s) in the `while` block. The `while` statement continues testing the
expression and executing its block until the expression evaluates to `false`.

The Java programming language also provides a `do-while` statement, which can be expressed as follows:

```
do { 
   statement(s)
} while (expression);
```

The difference between `do-while` and `while` is that `do-while` evaluates its expression at the bottom of the loop
instead of the top. Therefore, the statements within the `do block` are always executed **at least once**.

###### Interview Problem 3 (Merrill Lynch): Reverse Digits

Write a program which takes an integer and returns the integer corresponding to the digits of the input written in
reverse order. For example, the reverse of 1234 is 4321, and the reverse of -975 is -579.

**Solution**:

```java
public class ReverseDigits {

    public static long reverseUsingApi(final int num) {
        final boolean isNegative = num < 0;
        final long remaining = Math.abs(num);
        final var builder = new StringBuilder(String.valueOf(remaining));
        builder.reverse();
        final var result = Long.parseLong(builder.toString());
        return isNegative ? -result : result;
    }

    public static long reverse(final int num) {
        final boolean isNegative = num < 0;
        long result = 0L;
        long remaining = Math.abs(num);
        while (remaining != 0) {
            result = (result * 10) + (remaining % 10);
            remaining /= 10;
        }

        return isNegative ? -result : result;
    }

}
```

**Unit Test**:

```java
import org.junit.jupiter.api.Test;

public class ReverseDigitsTest {

    @Test
    void testReverse() {
        final int[] nums = new int[]{1234, -975, 5436, 87580, -1};
        for (final int num : nums) {
            System.out.printf("Num=[%d], reverseUsingApi=[%d], reverse=[%d]%n",
                              num,
                              ReverseDigits.reverseUsingApi(num),
                              ReverseDigits.reverse(num));
        }
    }

}
```

**Output**:

```
Num=[1234], reverseUsingApi=[4321], reverse=[4321]
Num=[-975], reverseUsingApi=[-579], reverse=[-579]
Num=[5436], reverseUsingApi=[6345], reverse=[6345]
Num=[87580], reverseUsingApi=[8578], reverse=[8578]
Num=[-1], reverseUsingApi=[-1], reverse=[-1]
```

###### Interview Problem 4 (Goldman Sachs): Check if a decimal integer is palindrome

A palindromic String is one which reads the same forwards and backwards, e.g. civic, radar, level, rotor, kayak,
reviver, madam.

Write a program which determines if an integer is palindrome. For ex: 1, 6, 11, 121, 333, 2147412 should return `true`,
and, -1, 12, 100, 2147483647 should return `false`. (any negative number is never a palindrome)

**Solution**:

```java
public class IsPalindromeNumber {

    public static boolean isPalindromeNumber(int num) {
        if (num < 0) return false;
        else if (num == 0) return true;

        // no of digits in a number
        // ex: 1234 = log10(1234) + 1 => (int) 3.091 + 1 => 4
        final int numDigits = (int) (Math.floor(Math.log10(num))) + 1;

        // most significant digit = num / (10^numDigits-1)
        // ex: 1234 / 1000 => (int) 1.234 => 1
        int msdMask = (int) Math.pow(10, numDigits - 1);

        // least significant digit = num % 10
        // ex: 1234 % 10 => 4
        for (int i = 0; i < (numDigits / 2); ++i) {
            if ((num / msdMask) != (num % 10)) { // compare msd with lsd
                return false;
            }
            num %= msdMask; // remove the most significant digit of num
            num /= 10; // remove the least significant digit of num
            msdMask /= 100; // as 2 digits are removed
        }

        return true;
    }

}
```

**Unit Test**:

```java
import org.junit.jupiter.api.Test;

public class IsPalindromeNumberTest {

    @Test
    void testPalindromeNumber() {
        final int[] nums = new int[]{1, 6, 11, 121, 333, 2147412, -1, 12, 100, 2147483647};
        for (final int num : nums) {
            System.out.printf("Num=[%d], isPalindrome=[%b]%n", num, IsPalindromeNumber.isPalindromeNumber(num));
        }
    }

}
```

**Output**:

```
Num=[1], isPalindrome=[true]
Num=[6], isPalindrome=[true]
Num=[11], isPalindrome=[true]
Num=[121], isPalindrome=[true]
Num=[333], isPalindrome=[true]
Num=[2147412], isPalindrome=[true]
Num=[-1], isPalindrome=[false]
Num=[12], isPalindrome=[false]
Num=[100], isPalindrome=[false]
Num=[2147483647], isPalindrome=[false]
```

###### Interview Problem 5 (Merrill Lynch): Compute `x` to the power `y`

Write a program that takes double `x` and an integer `y` and returns `x` to the power `y` => `x.pow(y)`.

**Solution**:

```java
public class Power {

    public static double powerUsingApi(final double x, final int y) {
        return Math.pow(x, y);
    }

    public static double power(double x, final int y) {
        double result = 1D;
        long pow = y;

        // when y is negative => replace x by 1/x and y with -y
        if (y < 0) {
            pow = -pow;
            x = 1D / x;
        }

        // when y is a power of 2 => can replace (x^2)^2, ....
        // thus, if the LSB of y is 0 => result is (x^(y/2))^2; otherwise it is (x * (x^(y/2))^2)
        while (pow != 0) {
            if ((pow & 1) != 0) { // LSB of y is not 0
                result *= x;
            }
            x *= x;
            pow >>>= 1; // right shift with 0, or it's equivalent to y/2
        }

        return result;
    }

}
```

**Unit Test**:

```java
import org.junit.jupiter.api.Test;

public class PowerTest {

    @Test
    void testPower() {
        final double[] nums = new double[]{2D, -3D, 1.1D};
        final int[] pows = new int[]{-3, 0, 1, 2, 3};
        for (final double x : nums) {
            for (final int y : pows) {
                System.out.printf("x=[%.2f], y=[%d], x.powerUsingApi(y)=[%.2f], x.power(y)=[%.2f]%n",
                                  x, y, Power.powerUsingApi(x, y), Power.power(x, y));
            }
            System.out.println();
        }
    }

}
```

**Output**:

```
x=[2.00], y=[-3], x.powerUsingApi(y)=[0.13], x.power(y)=[0.13]
x=[2.00], y=[0], x.powerUsingApi(y)=[1.00], x.power(y)=[1.00]
x=[2.00], y=[1], x.powerUsingApi(y)=[2.00], x.power(y)=[2.00]
x=[2.00], y=[2], x.powerUsingApi(y)=[4.00], x.power(y)=[4.00]
x=[2.00], y=[3], x.powerUsingApi(y)=[8.00], x.power(y)=[8.00]

x=[-3.00], y=[-3], x.powerUsingApi(y)=[-0.04], x.power(y)=[-0.04]
x=[-3.00], y=[0], x.powerUsingApi(y)=[1.00], x.power(y)=[1.00]
x=[-3.00], y=[1], x.powerUsingApi(y)=[-3.00], x.power(y)=[-3.00]
x=[-3.00], y=[2], x.powerUsingApi(y)=[9.00], x.power(y)=[9.00]
x=[-3.00], y=[3], x.powerUsingApi(y)=[-27.00], x.power(y)=[-27.00]

x=[1.10], y=[-3], x.powerUsingApi(y)=[0.75], x.power(y)=[0.75]
x=[1.10], y=[0], x.powerUsingApi(y)=[1.00], x.power(y)=[1.00]
x=[1.10], y=[1], x.powerUsingApi(y)=[1.10], x.power(y)=[1.10]
x=[1.10], y=[2], x.powerUsingApi(y)=[1.21], x.power(y)=[1.21]
x=[1.10], y=[3], x.powerUsingApi(y)=[1.33], x.power(y)=[1.33]
```

---

#### Chapter 02. Object-Oriented Programming
