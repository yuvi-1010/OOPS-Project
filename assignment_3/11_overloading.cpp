// Experiment 11 :
// Create class name is Integer in this class implement the overloading >> and<< opertor using friend function.

#include <bits/stdc++.h>
using namespace std;

class Integer
{
private:
    int value;

public:
    // Constructor
    Integer(int v = 0) : value(v) {}

    // Friend function to overload << operator for output
    friend ostream &operator<<(ostream &os, const Integer &obj)
    {
        os << obj.value;
        return os;
    }

    // Friend function to overload >> operator for input
    friend istream &operator>>(istream &is, Integer &obj)
    {
        is >> obj.value;
        return is;
    }
};

int main()
{
    Integer num;

    cout << "Enter an integer value: ";
    cin >> num;
    cout << "You entered: " << num << endl;

    return 0;
}