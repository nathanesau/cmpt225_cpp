#pragma once

#include <string>

class Person
{
private:
    const int id;
    std::string firstName;
    std::string lastName;
    const int gender;

public:
    static const int MALE = 1;
    static const int FEMALE = 2;

    Person(int newId, std::string newFirstName, std::string newLastName, int newGender) :
        id(newId), firstName(newFirstName), lastName(newLastName), gender(newGender)
    {
    }

    void setFirstName(std::string name) {
        firstName = name;
    }

    void setLastName(std::string name) {
        lastName = name;
    }

    int getId() const
    {
        return id;
    }

    std::string getFirstName() const {
        return firstName;
    }

    std::string getLastName() const {
        return lastName;
    }

    int getGender() const {
        return gender;
    }

    std::string getFullName() const {
        return firstName + " " + lastName;
    }

    std::string toString() const {
        return "Name = " + getFullName() + "; ID = " + std::to_string(id);
    }
};