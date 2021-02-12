#pragma once

#include <iostream>
#include <string>
#include "Comparable.h"

class ComparableClass : public Comparable<ComparableClass>
{
private:
    int id;
    std::string name;

public:
    ComparableClass(int id, std::string name) : id(id), name(name)
    {
    }

    int getId() const
    {
        return id;
    }

    std::string getName()
    {
        return name;
    }

    bool operator<(const ComparableClass &other) const override
    {
        if (this->id < other.id)
        {
            return true;
        }
        else if (this->id == other.id)
        {
            if (this->name < other.name)
            {
                return true;
            }
        }

        return false;
    }

    bool operator>(const ComparableClass &other) const override
    {
        if (this->id == other.id && this->name == other.name)
        {
            return false;
        }

        return !(*this < other);
    }

    std::string toString() const
    {
        return "id = " + std::to_string(id) + ", name = " + name;
    }
};