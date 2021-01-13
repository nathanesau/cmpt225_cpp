#include <vector>
#include <memory>
#include <random>
#include <iostream>
#include "animal.h"
#include "cow.h"
#include "dog.h"

std::unique_ptr<Animal> createRandomAnimal()
{
    switch (std::rand() % 3)
    {
    case 0:
        return std::make_unique<Cow>("Pink", "name" + std::to_string(std::rand() % 10), std::rand() % 200);

    case 1:
        return std::make_unique<Dog>("Spaniel", "Blue", "name" + std::to_string(std::rand() % 100));

    case 2:
        return std::make_unique<Dog>("Shepherd", "Gold", "name" + std::to_string(std::rand() % 100));
    }

    return nullptr;
}

int main()
{
    std::vector<std::unique_ptr<Animal>> animalList;
    for(int i = 0; i < 5; i++) {
        animalList.push_back(createRandomAnimal());
    }

    for(const auto &animal : animalList) {
        std::cout << animal->toString() << " says " << animal->makeSound() << std::endl;
    }

    return 0;
}