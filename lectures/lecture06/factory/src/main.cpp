#include <iostream>
#include <vector>
#include <memory>

#include "GeometricShape.h"
#include "GeometricShapeFactory.h"

int main()
{
    GeometricShapeFactory factory;
    std::vector<std::unique_ptr<GeometricShape>> shapes;
    shapes.push_back(factory.createShape("circle"));
    shapes.push_back(factory.createShape("square"));
    shapes.push_back(factory.createShape("rectangle"));

    for(int i = 0; i < shapes.size(); i++) {
        auto shape = shapes[i].get();
        std::cout << shape->toString() << std::endl;
    }

    return 0;
}