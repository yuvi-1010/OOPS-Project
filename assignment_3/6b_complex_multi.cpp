// Experiment 6b: Write a C++ Program to implement the arithmetic operations multiplication on complex numbers using the concept of this pointer, inline functions and scope resolution operator.
#include <bits/stdc++.h>
#define ll long long int
using namespace std;

class Complex
{
private:
    float real;
    float imag;

public:
    Complex(float r = 0, float i = 0) : real(r), imag(i) {}

    inline void setValues(float r, float i)
    {
        real = r;
        imag = i;
    }

    inline Complex multiply(const Complex &c) const
    {
        Complex result;
        result.real = (this->real * c.real) - (this->imag * c.imag);
        result.imag = (this->real * c.imag) + (this->imag * c.real);
        return result;
    }

    void display() const
    {
        if (imag >= 0)
            cout << real << " + " << imag << "i" << endl;
        else
            cout << real << " - " << -imag << "i" << endl;
    }
};

int main()
{
    Complex c1, c2, c3;
    float real1, imag1, real2, imag2;

    cout << "Enter the real part of 1st complex number: ";
    cin >> real1;
    cout << "Enter the img part of 1st complex number: ";
    cin >> imag1;

    c1.setValues(real1, imag1);

    cout << "Enter the real part of 2nd complex number: ";
    cin >> real2;
    cout << "Enter the img part of 2nd complex number: ";
    cin >> imag2;

    c2.setValues(real2, imag2);

    c3 = c1.multiply(c2);

    cout << "The result of multiplying the two complex numbers is: ";
    c3.display();

    return 0;
}