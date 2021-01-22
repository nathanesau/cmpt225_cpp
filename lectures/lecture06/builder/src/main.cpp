#include <iostream>
#include <vector>
#include <memory>

#include "GeometricShape.h"
#include "GeometricShapeBuilder.h"

int main()
{
    GeometricShapeBuilder builder;
    std::vector<std::unique_ptr<GeometricShape>> shapes;

    shapes.push_back(builder.setType("circle")
                         .setX(0)
                         .setY(0)
                         .setRadius(100)
                         .createShape());

    shapes.push_back(builder.setType("square")
                         .setX(10)
                         .setY(20)
                         .setLength(50)
                         .createShape());

    shapes.push_back(builder.setType("rectangle")
                         .setX(5)
                         .setY(15)
                         .setLength(20)
                         .setWidth(30)
                         .createShape());

    for (int i = 0; i < shapes.size(); i++)
    {
        std::cout << shapes[i].get()->toString() << std::endl;
    }

    return 0;
}