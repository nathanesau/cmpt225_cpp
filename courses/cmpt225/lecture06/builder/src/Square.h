#pragma once

#include "GeometricShape.h"

class Square : public GeometricShape
{
    int x;
    int y;
    int length;

public:
    Square(int x, int y, int length) :
        GeometricShape(), x(x), y(y), length(length)
    {
    }

    virtual ~Square()
    {
    }

    std::string toString() override
    {
        return "square: x = " + std::to_string(x) + ", y = " +  std::to_string(y)
            + ", length = " + std::to_string(length);
    }
};