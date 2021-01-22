#pragma once

#include <string>
#include "GeometricShape.h"

class Rectangle : public GeometricShape
{
public:
    Rectangle() : GeometricShape()
    {
    }

    std::string toString() override
    {
        return "rectangle";
    }
};