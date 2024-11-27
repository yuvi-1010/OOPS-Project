/*A department store places an order with a company for n pieces of miners, m pieces of
toasters, and P number of fans. The cost of each item is as follows:
 Miners: Rs. 1,500 per piece
 Toaster: Rs. 200 per piece
 Fan: Rs. 450 per piece
The discount allowed for various items are 5% for miners, 15% for fan, and 10% for toaster.
The company charge 10% as sales tax on all items on net value after deducting the discount.
Write a program that reads m, n, and p and computer the amount to be paid by the store.*/

#include <bits/stdc++.h>
#define ll long long int
using namespace std;

struct item
{
    int n, m, p;
    double cost, discount, tax, total;

    double price(int n, int m, int p)
    {
        cost = 1500 * n + 200 * m + 450 * p;
        discount = 0.05 * 1500 * n + 0.10 * 200 * m + 0.15 * 450 * p;
        tax = 0.10 * (cost - discount);
        total = cost - discount + tax;
        return total;
    }
};

int main()
{
    item i;
    cout << "Enter number of miners, toasters and fans : ";
    cin >> i.n >> i.m >> i.p;
    i.total = i.price(i.n, i.m, i.p);

    cout << "Amount to be paid : " << i.total << endl;
    return 0;
}