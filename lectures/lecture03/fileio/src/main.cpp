#include <iostream>
#include <fstream>
#include <sstream>

int main()
{
    // write to file
    std::ofstream outstream;
    outstream.open("file.txt");
    outstream << "hello world";
    outstream.close();

    // read file
    std::ifstream instream;
    instream.open("file.txt");
    std::stringstream strstream;
    strstream << instream.rdbuf();
    std::string data = strstream.str();
    instream.close();

    std::cout << "read following data from file: " << std::endl;
    std::cout << data << std::endl;

    return 0;
}