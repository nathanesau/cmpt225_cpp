#pragma once

#include <string>
#include "GeometricShape.h"

class Circle : public GeometricShape
{
public:
    Circle() :
        GeometricShape()
    {
    }

    std::string toString() override
    {
        return "circle";
    }
};