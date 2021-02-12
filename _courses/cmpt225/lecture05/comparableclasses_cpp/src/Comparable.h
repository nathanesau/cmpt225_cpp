#pragma once

template <class Type>
class Comparable
{
public:
    virtual bool operator<(const Type &other) const = 0;
    virtual bool operator>(const Type &other) const = 0;
};