#include <memory>
#include <iostream>
#include "person.h"
#include "student.h"

int main()
{
    auto tom = std::make_unique<Person>(123, "Tom", "Sawyer", Person::MALE);
    std::cout << tom->getFullName() << std::endl;

    auto huck = std::make_unique<Student>(456, "Huck", "Finn", Person::MALE);
    std::cout << huck->getFullName() << std::endl;
    std::cout << huck->toString() << std::endl;

    Person *huckPerson = huck.get();
    std::cout << huckPerson->toString() << std::endl;

    Student *huckStudent = static_cast<Student *>(huckPerson);
    std::cout << huckStudent->toString() << std::endl;

    return 0;
}