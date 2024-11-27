// Experiment 6a: Write a program to find mean of two numbers belonging to two different classes using friend function.
#include <bits/stdc++.h>
using namespace std;

// Forward declaration of class B
class B;

class A
{
private:
    float numA;

public:
    // Constructor to initialize numA
    A(float a = 0) : numA(a) {}

    void setNumA(float a)
    {
        numA = a;
    }

    // Friend function declaration to calculate mean
    friend float findMean(const A &objA, const B &objB);
};

class B
{
private:
    float numB;

public:
    // Constructor to initialize numB
    B(float b = 0) : numB(b) {}

    void setNumB(float b)
    {
        numB = b;
    }

    // Friend function declaration to calculate mean
    friend float findMean(const A &objA, const B &objB);
};

// Definition of the friend function
float findMean(const A &objA, const B &objB)
{
    return (objA.numA + objB.numB) / 2.0;
}

int main()
{
    A objA;
    B objB;

    float inputA, inputB;

    cout << "Enter the first number: ";
    cin >> inputA;
    objA.setNumA(inputA);

    cout << "Enter the second number: ";
    cin >> inputB;
    objB.setNumB(inputB);

    cout << "The mean of " << inputA << " and " << inputB << " is: " << findMean(objA, objB) << endl;

    return 0;
}