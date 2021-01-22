#pragma once

#include <string>
#include "GeometricShape.h"

class Square : public GeometricShape
{
public:
    Square() :
        GeometricShape()
    {
    }

    std::string toString() override
    {
        return "square";
    };
};