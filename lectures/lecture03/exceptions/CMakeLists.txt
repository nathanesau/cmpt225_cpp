cmake_minimum_required(VERSION 3.10)

set(CMAKE_CXX_STANDARD 20)

project(main)

add_executable(main
    src/circle.h
    src/exceptions.h
    src/main.cpp
)