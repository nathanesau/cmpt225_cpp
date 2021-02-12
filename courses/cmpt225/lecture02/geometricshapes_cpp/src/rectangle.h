#pragma once

#include "geometricshape.h"
#include <string>

class Rectangle : public GeometricShape
{
protected:
    int length;
    int width;

public:
    Rectangle(int initX, int initY, int initL, int initW) :
        GeometricShape(initX, initY),
        length(initL),
        width(initW)
    {
    }

    void setLength(int new_length)
    {
        length = new_length;
    }

    void setWidth(int new_width)
    {
        width = new_width;
    }

    void draw() const override
    {
        // drawing implementation...
    }

    std::string toString() const override
    {
        return "Rectangle: top-left=(" + std::to_string(x) + "," + std::to_string(y) + "), length = " +
            std::to_string(length) + ", width = " + std::to_string(width);
    }
};