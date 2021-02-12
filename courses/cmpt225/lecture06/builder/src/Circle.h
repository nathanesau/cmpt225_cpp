#pragma once

#include "GeometricShape.h"

class Circle : public GeometricShape
{
    int x;
    int y;
    int radius;

public:
    Circle(int x, int y, int radius) :
        GeometricShape(), x(x), y(y), radius(radius)
    {
    }

    virtual ~Circle()
    {
    }

    std::string toString() override
    {
        return "circle: x = " + std::to_string(x) + ", y = " + std::to_string(y) + ", radius = " + std::to_string(radius);
    }
};