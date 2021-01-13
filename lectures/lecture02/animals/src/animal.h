#pragma once

#include <string>

class Animal
{
public:
    virtual std::string makeSound() const = 0;

    virtual void draw() const = 0;

    virtual std::string toString() const = 0;
};