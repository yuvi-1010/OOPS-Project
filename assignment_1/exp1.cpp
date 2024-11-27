/*Suppose the postal rates for mailing letters are as follows:
 Rs. 0.50 per 10 grams for the first 50 grams,
 Rs. 0.40 per 10 grams for the next 100 grams,
 Rs. 0.25 per 10 grams for the next 250 grams, and
 Rs 25 per kilogram for letters weighing more than 400 grams.
 Write a program that prompts for the weight of a letter and prints the postage to be paid.*/
#include <bits/stdc++.h>
#define ll long long int
using namespace std;

struct post
{
    double weight;
    double cost;

    double calc(double weight)
    {
        double cost = 0.0;
        if (weight <= 50)
        {
            cost = (weight / 10) * 0.50;
        }
        else if (weight <= 150)
        {
            cost = (50 / 10) * 0.50;
            cost += ((weight - 50) / 10) * 0.40;
        }
        else if (weight <= 400)
        {
            cost = (50 / 10) * 0.50;
            cost += (100 / 10) * 0.40;
            cost += ((weight - 150) / 10) * 0.25;
        }
        else
        {
            cost = (weight / 1000) * 25;
        }
        return cost;
    }
};

int main()
{
    post Postage;
    cout << "Enter weight of letter in grams: ";
    cin >> Postage.weight;

    Postage.cost = Postage.calc(Postage.weight);
    cout << "Postage to be paid: Rs. " << Postage.cost << endl;

    return 0;
}