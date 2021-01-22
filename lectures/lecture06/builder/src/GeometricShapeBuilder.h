#pragma once

#include <string>
#include <memory>
#include "GeometricShape.h"
#include "Circle.h"
#include "Rectangle.h"
#include "Square.h"

class GeometricShapeBuilder
{
    std::string type;
    int x;
    int y;
    int radius;
    int length;
    int width;

public:
    GeometricShapeBuilder() = default;

    GeometricShapeBuilder &setType(std::string pType)
    {
        type = pType;
        return *this;
    }

    GeometricShapeBuilder &setX(int pX)
    {
        x = pX;
        return *this;
    }

    GeometricShapeBuilder &setY(int pY)
    {
        y = pY;
        return *this;
    }

    GeometricShapeBuilder &setRadius(int pRadius)
    {
        radius = pRadius;
        return *this;
    }

    GeometricShapeBuilder &setLength(int pLength)
    {
        length = pLength;
        return *this;
    }

    GeometricShapeBuilder &setWidth(int pWidth)
    {
        width = pWidth;
        return *this;
    }

    std::unique_ptr<GeometricShape> createShape()
    {
        if(type == "circle") {
            return std::make_unique<Circle>(x, y, radius);
        }
        else if (type == "rectangle") {
            return std::make_unique<Rectangle>(x, y, length, width);
        }
        else if (type == "square") {
            return std::make_unique<Square>(x, y, length);
        }

        return nullptr;
    }
};