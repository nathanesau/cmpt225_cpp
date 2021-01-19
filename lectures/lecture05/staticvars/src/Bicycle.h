#pragma once

#include <string>

class Bicycle
{
    static int createdBicycles;

protected:
    int gear;
    int speed;
    std::string color;

public:

    Bicycle(int gear, int speed, std::string color) :
        gear(gear), speed(speed), color(color)
    {
        createdBicycles++;
    }

    static int getNumberOfCreatedBicycles()
    {
        return createdBicycles;
    }
};

int Bicycle::createdBicycles = 0;
