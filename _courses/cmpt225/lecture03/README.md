# Lecture03 code samples

## C++

commandline sample output:

```bash
got following arguments:
- myflag
```

fileio sample output:

```bash
read following data from file: 
hello world
```

exceptions sample output:

```bash
caught exception: radius < 0
John is drinking coffee
John's coffee is just right.
John's coffee is too cold.
John's coffee is too hot.
```

## Java

commandline sample output:

```bash
The number of arguments is 0
----------------
```

fileio sample output:

```bash
Loading file...
hello world
hello world
```

exceptions sample output:

```bash
error message:  
radius < 0
-------
e.toString():
java.lang.IllegalArgumentException: radius < 0
-------
e.printStackTrace():
java.lang.IllegalArgumentException: radius < 0
        at example.geometry.Circle.setRadius(Circle.java:32)
        at example.App.geometryTest(App.java:18)
        at example.App.main(App.java:79)
-------
Stacks Trace:
example.geometry.Circle.setRadius(Circle.java:32)
example.App.geometryTest(App.java:18)
example.App.main(App.java:79)
John is drinking coffee
John's coffee is just right.
Clear the table
-----------
John's coffee is too cold.
Clear the table
-----------
John's coffee is too hot.
The error message is:
Customer's name: John. Coffee is too hot
Clear the table
```

## Rust

commandline sample output:

```bash
host: localhost
mode: default
```

fileio sample output:

```bash
wrote to file successfully
read from file successfully
```

exceptions sample output:

```bash
set radius successful
set radius failed
circle: radius = 15
coffee is just right
coffee is too cold
coffee is too hot
person: name = John
```