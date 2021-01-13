#pragma once

#include "person.h"
#include <array>
#include <numeric>

class Student : public Person
{
public:
    static const int NUMBER_OF_GRADES = 10;
    static const int MIN_GRADE = 0;
    static const int MAX_GRADE = 100;

private:
    std::array<int, NUMBER_OF_GRADES> grades{};

public:
    Student(int newId, std::string newFirstName, std::string newLastName, int newGender) :
        Person(newId, newFirstName, newLastName, newGender)
    {
    }

    void setGrade(int i, int newGrade) {
        if (i >= 1 && i <= NUMBER_OF_GRADES && newGrade >= MIN_GRADE && newGrade <= MAX_GRADE) {
            grades[i-1] = newGrade;
        }
    }

    double getAverage() const {
        return std::accumulate(grades.begin(), grades.end(), 0) / NUMBER_OF_GRADES;
    }

    std::string toString() const {
        return Person::toString() + "; Average grade = " + std::to_string(getAverage());
    }
};
