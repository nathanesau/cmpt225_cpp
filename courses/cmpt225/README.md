# CMPT225 - Data Structures and Programming - Spring 2021

My code for CMPT225 at SFU.

Code files are organized based on the lecture that they are related to.

## Summary

Note: the original language for the course is Java.

* Java code for (Lecture 01 - Lecture 08) is mostly written by instructor. I made some minor modifications, such as adding maven projects, etc.
* Rest of the code in this folder is written by [nathanesau](https://github.com/nathanesau).

The code for other languages was written by me.

| Lecture | Topic(s) | Java | C++ | Rust | Python |
| ------- | -------- | ---- | --- | ---- | ------ |
| Lecture 01 | General Information | Yes | Yes | Yes | No |
| Lecture 02 | Introduction to Java.<br /> Variables and strong typing.<br /> Basic OOP. | Yes | Yes | Yes | No |
| Lecture 03 | Basic OOP continued. | Yes | Yes | Yes | No |
| Lecture 04 | File I/O.<br /> Using command line arguments.<br />Exceptions. | No | No | No | No |
| Lecture 05 | n/a | Yes | Yes | Yes | No |
| Lecture 06 | n/a | Yes | Yes | Yes | No |
| Lecture 07 | n/a | Yes | Yes | Yes | No |
| Lecture 08 | n/a | Yes | Yes | Yes | No |
| Lecture 09 | n/a | Yes | Yes | No | Yes |
| Lecture 10 | n/a | Yes | No | No | Yes |
| Lecture 11 | n/a | No | No | No | No |
| Lecture 12 | n/a | No | No | No | Yes |

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
