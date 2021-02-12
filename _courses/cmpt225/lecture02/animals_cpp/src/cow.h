#pragma once

#include "animal.h"
#include <string>

class Cow : public Animal
{
protected:
    std::string color;
    std::string name;
    int weight;

public:
    Cow(std::string color, std::string name, int weight) : color(color), name(name), weight(weight)
    {
    }

    std::string getColor() const
    {
        return color;
    }
    
    std::string getName() const
    {
        return name;
    }

    int getWeight() const
    {
        return weight;
    }

    std::string makeSound() const override
    {
        return "moo";
    }

    void draw() const override
    {
        // drawing implementation...
    }

    std::string toString() const override
    {
        return "Cow: Color = " + color + " Name = " + name + " Weight = " + std::to_string(weight);
    }
};