#pragma once

#include "rectangle.h"
#include <string>

class Square : public Rectangle
{
public:
    Square(int initX, int initY, int initL) :
        Rectangle(initX, initY, initL, initL)
    {
    }

    void setLength(int new_length) {
        Rectangle::setLength(new_length);
        setWidth(new_length);
    }

    void draw() const override {
        // drawing implementation...
    }

    std::string toString() const override {
        return "Square: top-left=(" + std::to_string(x) + "," + std::to_string(y) + "), length = "
            + std::to_string(length);
    }
};