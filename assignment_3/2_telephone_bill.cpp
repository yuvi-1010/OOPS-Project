// The monthly telephone bill is to be computed as follows:
// Minimum Rs. 200 for upto 100 calls
// Plus Rs. 0.60 per call for next 50 calls
// Plus Rs. 0.50 per call for next 50 calls
// Plus Rs. 0.40 per call for any call beyond 200 calls.
// The input contains name of the customer and number of calls made and the desired output is the name and telephone bill to be paid by the customer.
// Create a class to represent an employee. It should include the following:
// Data Members:
// Name
// Number of calls
// Bill amount
// Member Functions:
// To input data
// To compute bill
// To output the desired information
// Using this class, write a program to accomplish the intended task.

#include <bits/stdc++.h>
#define ll long long int
using namespace std;

class Customer
{
private:
    string name;
    int numberOfCalls;
    double billAmount;

public:
    void inputData()
    {
        cout << "Enter the customer's name: ";
        getline(cin, name);
        cout << "Enter the number of calls made: ";
        cin >> numberOfCalls;
    }

    void computeBill()
    {
        if (numberOfCalls <= 100)
        {
            billAmount = 200;
        }
        else if (numberOfCalls <= 150)
        {
            billAmount = 200 + (numberOfCalls - 100) * 0.60;
        }
        else if (numberOfCalls <= 200)
        {
            billAmount = 200 + (50 * 0.60) + (numberOfCalls - 150) * 0.50;
        }
        else
        {
            billAmount = 200 + (50 * 0.60) + (50 * 0.50) + (numberOfCalls - 200) * 0.40;
        }
    }

    void displayData()
    {
        cout << "\nCustomer Name: " << name << endl;
        cout << "Bill Amount: Rs. " << billAmount << endl;
    }
};

int main()
{
    Customer customer;
    customer.inputData();
    customer.computeBill();
    customer.displayData();

    return 0;
}