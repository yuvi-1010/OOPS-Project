// 4. Create a class named Student with the following specifications:
//  Private Members:
//  admno of type integer to represent admission number
//  Name of type character to represent name ( max 20 characters)
//  marksEng of type float to represent marks in the subject of English
//  marKsMaths of type float to represent marks in the subject of
//  mathematics
//  marksSci of type float to represent marks in the subject of Science
//  total of type float to represent total marks
//  compute() A function to compute sum of marks in English, Maths and
//  Science
//  Public Members:
//  readData() A function to accept the data for admNo, name, marksEng,
//  MarksMaths, marksSci. It also invokes compute function to
//  Calculate total marks.
//  ShowData() A function that display all the data member on the
//  computer screen.
//  Note: Use the concept of inline, scope resolution, default argument, const function and static function.

#include <bits/stdc++.h>
#define ll long long int
using namespace std;

class Student
{
private:
    int admno;
    string name;
    float marksEng, marksMaths, marksSci, total;

    inline float compute(float marksEng, float marksMaths, float marksSci) const
    {
        return marksEng + marksMaths + marksSci;
    }

public:
    void readData()
    {
        cout << "Enter Admission Number: ";
        cin >> admno;
        cout << "Enter Name: ";
        cin >> name;
        cout << "Enter marks in English: ";
        cin >> marksEng;
        cout << "Enter marks in Mathematics: ";
        cin >> marksMaths;
        cout << "Enter marks in Science: ";
        cin >> marksSci;

        total = compute(marksEng, marksMaths, marksSci);
    }

    void showData() const
    {
        cout << "Admission Number: " << admno << endl;
        cout << "Name: " << name << endl;
        cout << "Marks in English: " << marksEng << endl;
        cout << "Marks in Mathematics: " << marksMaths << endl;
        cout << "Marks in Science: " << marksSci << endl;
        cout << "Total Marks: " << total << endl;
    }
};

int main()
{
    Student s1;
    s1.readData();
    s1.showData();

    return 0;
}