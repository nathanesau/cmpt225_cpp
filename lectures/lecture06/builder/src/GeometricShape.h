#pragma once

#include <string>

class GeometricShape
{
public:
    GeometricShape()
    {
    }

    virtual ~GeometricShape()
    {
    }

    virtual std::string toString() = 0;
};