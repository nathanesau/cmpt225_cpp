#include <iostream>

int main(int argc, char *argv[])
{
    std::cout << "got following arguments: " << std::endl;
    
    for (int i = 1; i < argc; i++) {
        std::cout << argv[i] << std::endl;
    }

    return 0;
}