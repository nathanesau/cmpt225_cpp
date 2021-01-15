#pragma once

#include <exception>

struct IllegalArgumentException : public std::exception
{
    IllegalArgumentException(const char *msg) :
        std::exception(msg)
    {
    }
};

struct TooColdException : public std::exception
{
    TooColdException(const char *msg) :
        std::exception(msg)
    {
    }
};

struct TooHotException : public std::exception
{
    TooHotException(const char *msg) :
        std::exception(msg)
    {
    }
};