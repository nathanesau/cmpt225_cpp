# CMPT225 - Data Structures and Programming - Spring 2021

My code for CMPT225 at SFU.

Code files are organized based on the lecture that they are related to.

## Summary

### Assignments

| Assignment | Link |
| ---------- | ---- | 
| Assignment 1 | [hw1-solution/README.md](hw1-solution/README.md) |
| Assignment 2 | [hw2-solution/README.md](hw2-solution/README.md) |
| Assignment 3 | [hw3-solution/README.md](hw3-solution/README.md) |

### Lectures

Note: the original language for the course is Java.

* Java code for (Lecture 01 - Lecture 08) is mostly written by instructor. I made some minor modifications, such as adding maven projects, etc.
* Rest of the code in this folder is written by [nathanesau](https://github.com/nathanesau).

| Lecture | Topic(s) | Java | C++ | Rust | Python |
| ------- | -------- | ---- | --- | ---- | ------ |
| Lecture 01 | General Information | Yes | Yes | Yes | No |
| Lecture 02 | Introduction to Java.<br /> Variables and strong typing.<br /> Basic OOP. | Yes | Yes | Yes | No |
| Lecture 03 | Basic OOP continued. | Yes | Yes | Yes | No |
| Lecture 04 | File I/O.<br /> Using command line arguments.<br />Exceptions. | No | No | No | No |
| Lecture 05 | Basic Java.<br /> Coding Style conventions. | Yes | Yes | Yes | No |
| Lecture 06 | Comparable interface.<br /> Singleton design pattern. | Yes | Yes | Yes | No |
| Lecture 07 | Two more factory design patterns.<br /> Factory, builder. <br /> Streams in Java. | Yes | Yes | Yes | No |
| Lecture 08 | Linked Lists. | Yes | Yes | Yes | No |
| Lecture 09 | Doubly Linked Lists. | Yes | Yes | No | Yes |
| Lecture 10 | Queues.<br /> Execution stack.<br /> A comment on recursion. | Yes | No | No | Yes |
| Lecture 11 | Big-O notation.<br /> Master Theorem. | No | No | No | No |
| Lecture 12 | Big-O notation.<br /> Master Theorem. | No | No | No | Yes |
| Lecture 13 | Master Theorem.<br /> Faster Integer Multiplication.<br /> Merge Sort - Iterative Implementation. | Yes | No | No | Yes |
| Lecture 14 | Trees.<br /> Binary Trees. | Yes | No | No | Yes | 
| Lecture 15 | Binary tree traverals. | Yes | No | No | No |

### Practice Problems

| Practice Set | Topic(s) | Language(s) | 
| ------------ | -------- | -------- |
| Practice 1 | Big-O Notation | n/a |
| Practice 2 | Master Theorem | n/a  |
| Practice 3 | Stacks and Queues | Java |
| Practice 4 | Binary Trees | Python |

## Development Instructions

## C++

```bash
# change into directory containing ``CMakeLists.txt``
mkdir build && cd build
cmake .. && make

# run the program
"Debug/main.exe"
```

## Java

```bash
# change into directory containing ``pom.xml``
mvn install

# run the program
java -jar target/example-1.0-SNAPSHOT.jar
```

## Rust

```bash
# change into directory containing ``Cargo.toml``
cargo build

# run the program
cargo run
```

## Additional Resources

CMPT 225 templates:

* https://github.com/nathanesau-academic/cmpt225_templates
