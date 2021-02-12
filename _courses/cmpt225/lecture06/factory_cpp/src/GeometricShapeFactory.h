#pragma once

#include <string>
#include <memory>

#include "Circle.h"
#include "Square.h"
#include "Rectangle.h"

class GeometricShapeFactory
{
public:
    GeometricShapeFactory() = default;

    std::unique_ptr<GeometricShape> createShape(std::string type) const
    {
        if (type == "circle") {
            return std::make_unique<Circle>();
        }
        else if (type == "square") {
            return std::make_unique<Square>();
        }
        else if (type == "rectangle") {
            return std::make_unique<Rectangle>();
        }
        
        return nullptr;
    }
};