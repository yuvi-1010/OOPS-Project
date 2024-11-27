// 3. Design a class named Data with day, month and year (all of type int) as its data members declared in
//  private section of the class. Define the following constructor for the class:
//  (i) Zero argument constructor that initialize the day, month and year data members to 12, 3 and 1993 respectively.
//  (ii) Parameterized constructor which takes three arguments, all of which are declared with default values as 12, 10 and
//  2000 respectively the day, month and year data members with corresponding arguments.
//  (iii) Copy constructor.
#include <bits/stdc++.h>
#define ll long long int
using namespace std;

class Date
{

private:
    int day;
    int month;
    int year;

public:
    Date(int day = 12, int month = 10, int year = 2000)
    {
        this->day = day;
        this->month = month;
        this->year = year;
    }
    Date(Date &d1)
    {
        this->day = d1.day;
        this->month = d1.month;
        this->year = d1.year;
    }
    void getData()
    {
        cout << "The date is: " << day << " " << month << " " << year << endl;
    }
};
int main()
{
    Date d1(1, 5);
    Date d2(1, 5, 2001);
    Date d3(d2);
    Date d4;
    d1.getData();
    d2.getData();
    d3.getData();
    d4.getData();
    return 0;
}