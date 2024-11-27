// Experiment 13:
// Create class name is Integer in this class implement the operator over loading using friend function Binary(+) operator.
#include <bits/stdc++.h>
#define ll long long int
using namespace std;

class Integer
{
private:
    int value;

public:
    // Constructor
    Integer(int v = 0) : value(v) {}

    // Friend function to overload the + operator
    friend Integer operator+(const Integer &lhs, const Integer &rhs)
    {
        return Integer(lhs.value + rhs.value);
    }

    void setValue(int v)
    {
        value = v;
    }

    int getValue() const
    {
        return value;
    }
};

int main()
{
    Integer num1, num2;

    int input1, input2;
    cout << "Enter the first integer: ";
    cin >> input1;
    num1.setValue(input1);

    cout << "Enter the second integer: ";
    cin >> input2;
    num2.setValue(input2);

    // Use overloaded + operator to add num1 and num2
    Integer result = num1 + num2;

    cout << "The result of num1 + num2 is: " << result.getValue() << endl;

    return 0;
}