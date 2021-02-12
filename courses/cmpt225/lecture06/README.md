# Lecture06 code samples

## C++

builder sample output:

```bash
circle: x = 0, y = 0, radius = 100
square: x = 10, y = 20, length = 50
rectangle: x = 5, y = 15, length = 20, width = 30
```

factory sample output:

```bash
circle
square
rectangle
```

singleton sample output:

```bash
the objects are equal: 
s1.val: 41
s2.val: 41
```

## Rust

builder_rust sample output:

```bash
circle {x: 5, y: 5 radius: 10}
square {x: 5, y: 5, length: 10}
rectangle {x: 5, y: 5, length: 10, radius: 15}
```

factory_rust sample output:

```bash
radius 10
circle {y: 5, x: 5, radius: 10}
square {length: 10, x: 5, y: 5}
rectangle {y: 5, length: 10, x: 5, width: 15}
```

singleton_rust sample output:

```bash
s1::value: 53
s2::value: 53
```