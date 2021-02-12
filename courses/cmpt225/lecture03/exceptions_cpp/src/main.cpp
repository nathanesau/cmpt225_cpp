#include <iostream>
#include "circle.h"
#include "person.h"
#include "exceptions.h"

void circleTest()
{
    Circle circle(1, 10, 5);

    try
    {
        circle.setRadius(-3);
    }
    catch (const IllegalArgumentException &e)
    {
        std::cout << "caught exception: " << e.what() << std::endl;
    }
}

void serveCustomer(const Person &person, std::string temperatue)
{
    try
    {
        person.drinkCoffee(temperatue);
        std::cout << person.getName() << "'s coffee is just right." << std::endl;
    }
    catch (const TooColdException &)
    {
        std::cout << person.getName() << "'s coffee is too cold." << std::endl;
    }
    catch (const TooHotException &)
    {
        std::cout << person.getName() << "'s coffee is too hot." << std::endl;
    }
}

void personTest()
{
    Person person("John");
    serveCustomer(person, "just right");
    serveCustomer(person, "too cold");
    serveCustomer(person, "too hot");
}

int main()
{
    // test IllegalArgumentException
    circleTest();

    // test TooColdException, TooHotException
    personTest();

    return 0;
}