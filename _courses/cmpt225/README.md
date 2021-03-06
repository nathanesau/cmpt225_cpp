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
| Assignment 4 | [hw4-solution/README.md](hw4-solution/README.md) |

### Lectures

Note: the original language for the course is Java.

* Most of the code in this folder is written by [nathanesau](https://github.com/nathanesau). Some of the Java code was written by instructor.

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
| Lecture 16 | Arithmetic expressions<br /> Infix/ Prefix/ Postfix notations. | No | No | No | No |
| Lecture 17 | Arithmetic expressions<br /> Infix/ Prefix/ Postfix notations.<br /> Representation using binary trees. | Yes | No | No | No |
| Lecture 18 | Priority queues<br /> Heaps. | Yes | No | No | Yes |
| Lecture 19 | Heaps. | Yes | No | No | No |
| Lecture 20 | Binary Search Trees. | No | No | No | Yes |
| Lecture 21 | Binary Search Trees. | No | No | No | No |
| Lecture 22 | Graphs<br /> Breadth First Search<br /> Depth First Search<br />. | No | No | No | No | 
| Lecture 23 | A* algorithm. | No | No | No | No |
| Lecture 24 | Graph Traversals. | No | No | No | No |
| Lecture 25 | Hashing<br /> Separate Chaining. | No | No | No | No |
| Lecture 26 | Hashing<br /> Open addressing/ probing<br /> 3-Sum. | No | No | No | No |
| Lecture 27 | HashSet and HashMap<br /> 3-Sum. | No | No | No | No |
| Lecture 28 | AVL trees. | No | No | No | No |
| Lecture 29 | AVL trees. | No | No | No | No |
| Lecture 30 | B-trees. | No | No | No | No |
| Lecture 31 | Union-find. | Yes | No | No | Yes |
| Lecture 32 | Union-find.<br /> Kruskal's algorithm. | No | No | No | No |
| Lecture 33 | Selection algorithm. | No | No | No | No |

### Practice Problems

Note: some practice sets were only partially completed.

| Practice Set | Topic(s) | Language(s) | 
| ------------ | -------- | -------- |
| Practice 1 | Big-O Notation | n/a |
| Practice 2 | Master Theorem | n/a  |
| Practice 3 | Stacks and Queues | Java |
| Practice 4 | Binary Trees | Python |
| Practice 5 | Heaps | Python |
| Practice 6 | Binary Search Trees | Python |

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
