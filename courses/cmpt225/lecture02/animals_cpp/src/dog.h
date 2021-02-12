#pragma once

#include "animal.h"
#include <string>

class Dog : public Animal
{
protected:
    std::string breed;
    std::string color;
    std::string name;

public:
    Dog(std::string breed, std::string color, std::string name) :
        breed(breed), color(color), name(name)
    {
    }

    std::string getBreed() const
    {
        return breed;
    }

    std::string getColor() const
    {
        return color;
    }

    std::string getName() const
    {
        return name;
    }

    std::string makeSound() const override
    {
        return "woof-woof";
    }

    void draw() const override
    {
        // drawing implementation...
    }

    std::string toString() const override
    {
        return "Dog: Breed = " + breed + " Color = " + color + " Name = " + name;
    }
};