#include <vector>
#include <memory>
#include <random>
#include <iostream>
#include "geometricshape.h"
#include "circle.h"
#include "square.h"
#include "rectangle.h"

std::unique_ptr<GeometricShape> createRandomShape()
{
    switch (std::rand() % 3)
    {
    case 0:
        return std::make_unique<Circle>(std::rand() % 100, std::rand() % 100, std::rand() % 50);

    case 1:
        return std::make_unique<Square>(std::rand() % 100, std::rand() % 100, std::rand() % 50);

    case 2:
        return std::make_unique<Rectangle>(std::rand() % 100, std::rand() % 100, std::rand() % 50, std::rand() % 50);
    }

    return nullptr;
}

int main()
{
    std::vector<std::unique_ptr<GeometricShape>> shapeList;
    for(int i = 0; i < 10; i++) {
        shapeList.push_back(createRandomShape());
    }

    for(const auto &shape : shapeList) {
        std::cout << shape->toString() << std::endl;
    }

    return 0;
}