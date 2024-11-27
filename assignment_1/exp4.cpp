/* The monthly telephone bill is to be computed as follows:
 Minimum Rs. 200 for up to 100 calls
 Plus Rs. 0.60 per call for next 50 calls
 Plus Rs. 0.50 per call for next 50 calls
 Plus Rs. 0.40 per call for any call beyond 200 calls.
The input contains the name of the customer and the number of calls made, and the desired output is the
name and telephone bill to be paid by the customer.
Create a class to represent an employee. It should include the following:
 Data Members:
 Name
 Number of calls
 Bill amount
 Member Functions:
 To input data
 To compute bill
 To output the desired information
Using this structure, write a program to accomplish the intended task.*/

#include <bits/stdc++.h>
using namespace std;

struct Customer
{
    string name;
    int number_of_calls;
    float bill_amount;

    void input_data()
    {
        cout << "Enter the customer's name: ";
        getline(cin, name);
        cout << "Enter the number of calls made: ";
        cin >> number_of_calls;
    }

    void compute_bill()
    {
        if (number_of_calls <= 100)
        {
            bill_amount = 200;
        }
        else if (number_of_calls <= 150)
        {
            bill_amount = 200 + (number_of_calls - 100) * 0.60;
        }
        else if (number_of_calls <= 200)
        {
            bill_amount = 200 + 50 * 0.60 + (number_of_calls - 150) * 0.50;
        }
        else
        {
            bill_amount = 200 + 50 * 0.60 + 50 * 0.50 + (number_of_calls - 200) * 0.40;
        }
    }

    void output_data()
    {
        cout << "Customer's Name: " << name << endl;
        cout << "Telephone Bill Amount: Rs. " << bill_amount << endl;
    }
};

int main()
{
    Customer customer;

    customer.input_data();
    customer.compute_bill();
    customer.output_data();

    return 0;
}