# Tutorial 5

Topics covered:

* Karatsuba's algorithm. See [karatsuba.py](../lecture12/python/karatsuba.py)
* Call Stack. See [https://godbolt.org/](godbolt.org)

For callstack, example code is below.

```cpp
int sum_first_n(int n) {
    if (n == 1) {
        return 1;
    }

    return sum_first_n(n-1) + n;
}
```

and here is the godbolt output. the assembly code has jump statement for n == 1.

```assembly
sum_first_n(int):
        mov     eax, edi
        cmp     edi, 1
        je      .L5
        push    rbx
        mov     ebx, edi
        lea     edi, [rdi-1]
        call    sum_first_n(int)
        add     eax, ebx
        pop     rbx
        ret
.L5:
        ret
```