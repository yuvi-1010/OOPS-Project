// Experiment 9: (Dynamic memory allocation with new, delete, and destructor)
// A Program to allocate contiguous memory for an array using the new operator and the object of the array is destroyed by the delete operator.
#include <bits/stdc++.h>
#define ll long long int
using namespace std;

class Array
{
private:
    int *arr;
    int size;

public:
    // Constructor
    Array(int s)
    {
        size = s;
        arr = new int[size]; // Dynamically allocate memory for the array
        cout << "Memory allocated for array of size " << size << "." << endl;
    }

    // Destructor
    ~Array()
    {
        delete[] arr; // Deallocate the memory
        cout << "Memory deallocated." << endl;
    }

    void input()
    {
        cout << "Enter " << size << " elements:" << endl;
        for (int i = 0; i < size; ++i)
        {
            cin >> arr[i];
        }
    }

    void display() const
    {
        cout << "Array elements are:" << endl;
        for (int i = 0; i < size; ++i)
        {
            cout << arr[i] << " ";
        }
        cout << endl;
    }
};

int main()
{
    int n;
    cout << "Enter the size of the array: ";
    cin >> n;

    Array myArray(n);
    myArray.input();
    myArray.display();

    return 0;
}