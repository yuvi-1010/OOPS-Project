// 6. WAP that displays the name of topper in a class.

#include <bits/stdc++.h>
#define ll long long int
using namespace std;

class Student
{
private:
    string name;
    int marks;

public:
    Student(const string &name, int marks) : name(name), marks(marks) {}

    string getName() const
    {
        return name;
    }

    int getMarks() const
    {
        return marks;
    }

    void setName(const string &newName)
    {
        name = newName;
    }

    void setMarks(int newMarks)
    {
        marks = newMarks;
    }
};

int main()
{
    int n;
    cout << "Enter the number of students: ";
    cin >> n;
    vector<Student> students;

    for (int i = 0; i < n; ++i)
    {
        string name;
        int marks;
        cout << "Enter the name of student " << i + 1 << ": ";
        cin >> ws; // to consume any leading whitespace
        getline(cin, name);
        cout << "Enter the marks of student " << i + 1 << ": ";
        cin >> marks;
        students.emplace_back(name, marks);
    }

    Student topper = students[0];

    for (const auto &student : students)
    {
        if (student.getMarks() > topper.getMarks())
        {
            topper = student;
        }
    }

    cout << "The topper is " << topper.getName() << " with " << topper.getMarks() << " marks." << endl;

    return 0;
}