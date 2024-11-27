// Experiment 1:
// An employer plane to pay a bonus to employees. A bonus of 10% is to be paid to employees with earning at least Rs. 2000/- of the earning to others. The input contains name and earning of an employee and the desired output is name and bonus to be paid to the employee.
// Create a class to represent an employee. It should incluse the following:
// Data Members:
// Name
// Earning
// Bonus
// Member Functions:
// To input data
// To compute bonus
// To output the desired information
// Using this class, write a program to accomplish the intended task.
#include <bits/stdc++.h>
using namespace std;

class Employee
{
private:
    string name;
    float earning;
    float bonus;

public:
    void inputData()
    {
        cout << "Enter employee name: ";
        getline(cin, name);
        cout << "Enter employee earning: ";
        cin >> earning;
    }

    void computeBonus()
    {
        if (earning >= 2000)
        {
            bonus = earning * 0.10; // 10% bonus for earning >= 2000
        }
        else
        {
            bonus = earning * 0.05; // 5% bonus for earning < 2000
        }
    }

    void outputData() const
    {
        cout << "Employee Name: " << name << endl;
        cout << "Bonus to be paid: Rs. " << bonus << endl;
    }
};

int main()
{
    Employee emp;

    emp.inputData();
    emp.computeBonus();
    emp.outputData();

    return 0;
}