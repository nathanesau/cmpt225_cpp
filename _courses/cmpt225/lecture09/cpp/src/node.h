#pragma once

#include <string>

template <class Type>
struct Node
{
    Type data;

    Node *next;

    Node *prev;

    Node(Type data) : data(data), next(nullptr), prev(nullptr)
    {        
    }
};
