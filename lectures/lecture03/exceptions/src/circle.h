#pragma once

#include <utility>
#include <numbers>
#include "exceptions.h"

class Circle
{
protected:
    std::pair<int, int> center;
    int radius;

public:
    Circle(int x, int y, int r) : center(std::make_pair(x, y)),
                                  radius(r)
    {
    }

    void setRadius(int r)
    {
        if (r < 0) {
            throw IllegalArgumentException("radius < 0");
        }

        radius = r;
    }

    double getArea()
    {
        // C++20 added a pi constant!
        return std::numbers::pi * radius * radius;
    }
};