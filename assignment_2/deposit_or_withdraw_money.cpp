// 8. Write class and object based program to deposit or withdraw money in a bank account

#include <bits/stdc++.h>
#define ll long long int
using namespace std;

class BankAccount
{
private:
    string accountNumber;
    string accountHolderName;
    double balance;

public:
    BankAccount(string accountNumber, string accountHolderName, double balance)
    {
        this->accountNumber = accountNumber;
        this->accountHolderName = accountHolderName;
        this->balance = balance;
    }

    void deposit(double amount)
    {
        if (amount > 0)
        {
            balance += amount;
            cout << "Deposit successful. New balance: " << balance << endl;
        }
        else
        {
            cout << "Invalid deposit amount." << endl;
        }
    }

    void withdraw(double amount)
    {
        if (amount > 0 && amount <= balance)
        {
            balance -= amount;
            cout << "Withdrawal successful. New balance: " << balance << endl;
        }
        else if (amount > balance)
        {
            cout << "Insufficient balance." << endl;
        }
        else
        {
            cout << "Invalid withdrawal amount." << endl;
        }
    }

    void displayDetails() const
    {
        cout << "Account Number: " << accountNumber << endl;
        cout << "Account Holder Name: " << accountHolderName << endl;
        cout << "Balance: " << balance << endl;
    }
};

int main()
{
    string accountNumber;
    string accountHolderName;
    double initialBalance;

    cout << "Enter Account Number: ";
    cin >> accountNumber;
    cin.ignore(); // To ignore the newline character left in the buffer
    cout << "Enter Account Holder Name: ";
    getline(cin, accountHolderName);
    cout << "Enter Initial Balance: ";
    cin >> initialBalance;

    BankAccount account(accountNumber, accountHolderName, initialBalance);

    cout << "\nInitial Account Details:" << endl;
    account.displayDetails();

    double amount;
    cout << "\nEnter amount to deposit: ";
    cin >> amount;
    account.deposit(amount);

    cout << "\nEnter amount to withdraw: ";
    cin >> amount;
    account.withdraw(amount);

    cout << "\nUpdated Account Details:" << endl;
    account.displayDetails();

    return 0;
}