#pragma once

#include <string>
#include "exceptions.h"

struct Person
{
protected:
    std::string name;   

public:
    Person(std::string nm) : name(nm)
    {
    }

    std::string getName() const
    {
        return name;
    }

    void drinkCoffee(std::string temperature) const
    {
        if (temperature == "just right") {
            std::cout << name << " is drinking coffee" << std::endl;
        }
        else if (temperature == "too cold") {
            throw TooColdException("coffee is too cold");
        }
        else if (temperature == "too hot") {
            throw TooHotException("cofeee is too hot");
        }
    }
};
