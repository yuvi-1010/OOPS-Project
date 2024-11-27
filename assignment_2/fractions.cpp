// 5. WAP to add and substract two fractions. Let the add() accept the objects using call-by-value technique, subtract() using call-by-reference, and multiply() accept using the call-by-address technique.
#include <bits/stdc++.h>
using namespace std;

class Fraction
{
public:
    int numerator;
    int denominator;

    Fraction(int num = 0, int den = 1) : numerator(num), denominator(den)
    {
        if (denominator == 0)
        {
            cout << "Denominator cannot be zero. Setting it to 1." << endl;
            denominator = 1;
        }
        reduce();
    }

    int gcd(int a, int b) const
    {
        while (b != 0)
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    void reduce()
    {
        int gcd_value = gcd(numerator, denominator);
        numerator /= gcd_value;
        denominator /= gcd_value;
    }

    void display() const
    {
        cout << numerator << "/" << denominator << endl;
    }

    Fraction add(Fraction f) const
    {
        int num = numerator * f.denominator + f.numerator * denominator;
        int den = denominator * f.denominator;
        return Fraction(num, den);
    }

    Fraction subtract(const Fraction &f) const
    {
        int num = numerator * f.denominator - f.numerator * denominator;
        int den = denominator * f.denominator;
        return Fraction(num, den);
    }

    Fraction multiply(const Fraction *f) const
    {
        int num = numerator * f->numerator;
        int den = denominator * f->denominator;
        return Fraction(num, den);
    }
};

int main()
{
    int num, den;

    // Input for Fraction 1
    cout << "Enter numerator for Fraction 1: ";
    cin >> num;
    cout << "Enter denominator for Fraction 1: ";
    cin >> den;
    Fraction f1(num, den);

    // Input for Fraction 2
    cout << "Enter numerator for Fraction 2: ";
    cin >> num;
    cout << "Enter denominator for Fraction 2: ";
    cin >> den;
    Fraction f2(num, den);

    cout << "Fraction 1: ";
    f1.display();
    cout << "Fraction 2: ";
    f2.display();

    // Add
    Fraction result_add = f1.add(f2);
    cout << "Addition Result: ";
    result_add.display();

    // Subtract
    Fraction result_subtract = f1.subtract(f2);
    cout << "Subtraction Result: ";
    result_subtract.display();

    // Multiply
    Fraction result_multiply = f1.multiply(&f2);
    cout << "Multiplication Result: ";
    result_multiply.display();

    return 0;
}