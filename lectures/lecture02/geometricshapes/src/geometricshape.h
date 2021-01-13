#pragma once

#include <string>

class GeometricShape
{
protected:
    int x;
    int y;

public:
    GeometricShape(int initX, int initY) : x(initX), y(initY)
    {
    }

    void moveTo(int newX, int newY)
    {
        x = newX;
        y = newY;
    }

    virtual void draw() const = 0;

    virtual std::string toString() const = 0;
};