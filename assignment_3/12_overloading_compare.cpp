// Experiment 12:
// Create class name is Integer in this class implement the operator over loading using Compare to String.

#include <bits/stdc++.h>
using namespace std;

class Integer
{
private:
    int value;

public:
    // Constructor
    Integer(int v = 0) : value(v) {}

    // Method to set the value from a string
    void setValueFromString(const string &str)
    {
        value = stoi(str);
    }

    // Overload == operator to compare Integer with a string
    bool operator==(const string &str) const
    {
        int strValue = stoi(str);
        return value == strValue;
    }

    // Overload != operator to compare Integer with a string
    bool operator!=(const string &str) const
    {
        int strValue = stoi(str);
        return value != strValue;
    }

    // Overload >> operator to take string input
    friend istream &operator>>(istream &is, Integer &obj)
    {
        string str;
        is >> str;
        obj.value = stoi(str);
        return is;
    }

    // Overload << operator for output
    friend ostream &operator<<(ostream &os, const Integer &obj)
    {
        os << obj.value;
        return os;
    }
};

int main()
{
    Integer num;

    cout << "Enter an integer value: ";
    cin >> num;

    string str1 = "18";
    string str2 = "45";

    // Compare Integer with string
    if (num == str1)
    {
        cout << "num is equal to " << str1 << endl;
    }
    else
    {
        cout << "num is not equal to " << str1 << endl;
    }

    if (num != str2)
    {
        cout << "num is not equal to " << str2 << endl;
    }
    else
    {
        cout << "num is equal to " << str2 << endl;
    }

    return 0;
}