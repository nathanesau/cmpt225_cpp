#pragma once

#include "GeometricShape.h"

class Rectangle : public GeometricShape
{
    int x;
    int y;
    int length;
    int width;

public:
    Rectangle(int x, int y, int length, int width) : 
        GeometricShape(), x(x), y(y), length(length), width(width)
    {
    }

    virtual ~Rectangle()
    {
    }

    std::string toString() override
    {
        return "rectangle: x = " + std::to_string(x) + ", y = " + std::to_string(y)
            + ", length = " + std::to_string(length) + ", width = " + std::to_string(width);
    }
};