#pragma once

#include <random>

class Singleton
{
    int val;

    // the unique instance
    static Singleton instance;

    Singleton()
    {
        val = std::rand() % 100;
    }

public:
    static Singleton getInstance()
    {
        // alternatively, could create instance
        // here if it is not yet created
        return instance;
    }

    int getVal() const
    {
        return val;
    }
};

Singleton Singleton::instance = Singleton();