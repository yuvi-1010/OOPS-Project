// 7. WAP that uses an overloaded constructor to dynamically allocate memory to an array and thus find the largest of its elements.

#include <bits/stdc++.h>
using namespace std;

class Array
{
private:
    int *arr;
    int size;

public:
    Array(int s)
    {
        size = s;
        arr = new int[size];
        cout << "Enter " << size << " elements:" << endl;
        for (int i = 0; i < size; i++)
        {
            cin >> arr[i];
        }
    }

    Array(const Array &other)
    {
        size = other.size;
        arr = new int[size];
        for (int i = 0; i < size; i++)
        {
            arr[i] = other.arr[i];
        }
    }

    ~Array()
    {
        delete[] arr;
    }

    int findLargest() const
    {
        int largest = arr[0];
        for (int i = 1; i < size; i++)
        {
            if (arr[i] > largest)
            {
                largest = arr[i];
            }
        }
        return largest;
    }

    void display() const
    {
        cout << "Array elements: ";
        for (int i = 0; i < size; i++)
        {
            cout << arr[i] << " ";
        }
        cout << endl;
    }
};

int main()
{
    int size;
    cout << "Enter the size of the array: ";
    cin >> size;

    Array arr(size);
    arr.display();

    int largest = arr.findLargest();
    cout << "The largest element in the array is: " << largest << endl;

    return 0;
}