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
    - Java Basics
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

