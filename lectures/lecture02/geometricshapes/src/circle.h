#pragma once

#include "geometricshape.h"
#include <string>

class Circle : public GeometricShape
{
protected:
    int radius;

public:
    Circle(int initX, int initY, int initR) : GeometricShape(initX, initY),
                                              radius(initR)
    {
    }

    void setRadius(int newR)
    {
        radius = newR;
    }

    void draw() const override
    {
        // drawing implementation...
    }

    std::string toString() const override
    {
        return "Circle: center=(" + std::to_string(x) + "," + std::to_string(y) + "), radius = " +
            std::to_string(radius);
    }
};