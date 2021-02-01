# cmpt225_cpp

C++ implementations for CMPT225 lecture slides at Simon Fraser University (Spring 2021).

## File Summary

| Lecture | Java | C++ | Rust | Python |
| ------- | ---- | --- | ---- | ------ |
| Lecture 01 | Yes (different repo) | Yes | Yes | No |
| Lecture 02 | Yes (different repo) | Yes | Yes | No |
| Lecture 03 | Yes (different repo) | Yes | Yes | No |
| Lecture 04 | Yes (different repo) | No | No | No |
| Lecture 05 | Yes (different repo) | Yes | Yes | No |
| Lecture 06 | Yes (different repo) | Yes | Yes | No |
| Lecture 07 | Yes (different repo) | Yes | Yes | No |
| Lecture 08 | Yes (different repo)  | Yes | Yes | No |
| Lecture 09 | Yes (different repo) | No | No | Yes |
| Lecture 10 | Yes (different report) | No | No | Yes |

General Language Thoughts:

* Python is very fast to write code for
* C++ is pretty fast to write code for
* Rust is kind of slow to write code for (for Linked List, Stack, etc.)

Maybe if I were better at Rust I would be quicker at it. :smiley:

## Requirements

* cmake: https://github.com/Kitware/CMake/releases/download/v3.19.2/cmake-3.19.2-win64-x64.msi


## Development Instructions

Compile instructions to be run in directory containing ``CMakeLists.txt``:

```bash
mkdir build && cd build
cmake .. && cmake --build .

# run the program
"Debug/main.exe"
```
