// Experiment 7: Create a record of 10 employee which contains following information: emp_id., emp_name, and age. Create a C++ (OOPs concept) program to search an employee with its emp_id.
#include <bits/stdc++.h>
#define ll long long int
using namespace std;

class Employee
{
private:
    int emp_id;
    string emp_name;
    int age;

public:
    // Constructor
    Employee() : emp_id(0), emp_name(""), age(0) {}

    void input()
    {
        cout << "Enter Employee ID: ";
        cin >> emp_id;
        cin.ignore();
        cout << "Enter Employee Name: ";
        getline(cin, emp_name);
        cout << "Enter Age: ";
        cin >> age;
    }

    void display() const
    {
        cout << "Employee ID: " << emp_id << ", Name: " << emp_name << ", Age: " << age << endl;
    }

    int getEmpID() const
    {
        return emp_id;
    }
};

class EmployeeRecords
{
private:
    Employee employees[2];

public:
    void inputEmployees()
    {
        for (int i = 0; i < 2; ++i)
        {
            cout << "Enter details for Employee " << i + 1 << ":" << endl;
            employees[i].input();
            cout << endl;
        }
    }

    void searchByEmpID(int id) const
    {
        bool found = false;
        for (int i = 0; i < 2; ++i)
        {
            if (employees[i].getEmpID() == id)
            {
                cout << "Employee found:" << endl;
                employees[i].display();
                found = true;
                break;
            }
        }
        if (!found)
        {
            cout << "Employee with ID " << id << " not found." << endl;
        }
    }
};

int main()
{
    EmployeeRecords records;
    records.inputEmployees();

    int search_id;
    cout << "Enter Employee ID to search: ";
    cin >> search_id;

    records.searchByEmpID(search_id);

    return 0;
}