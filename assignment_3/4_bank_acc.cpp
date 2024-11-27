// Create a class to represent a bank account. It should include the following:
// Data Members:
//     Name of account holder
//     Account number
//     Type of account
//     Balance amount
// Member Function:
//     To initialize the data members with appropriate data
//     To deposit an amount
//     To withdraw an amount after checking the balance
//     To display details of account holder
// Write a program to use this class.
#include <bits/stdc++.h>
#define ll long long int
using namespace std;

class BankAcc
{
private:
    string name;
    string accno;
    string type;
    double balance;

public:
    void initialize()
    {
        cout << "Enter account holder's name: ";
        getline(cin, name);
        cout << "Enter account number: ";
        getline(cin, accno);
        cout << "Enter account type (Savings/Current): ";
        getline(cin, type);
        cout << "Enter initial balance: Rs. ";
        cin >> balance;
        cin.ignore();
    }
    void deposit()
    {
        double amount;
        cout << "Enter the amount to deposit: Rs. ";
        cin >> amount;
        if (amount > 0)
        {
            balance += amount;
            cout << "Amount Rs. " << amount << " deposited successfully." << endl;
        }
        else
        {
            cout << "Invalid amount." << endl;
        }
    }
    void withdraw()
    {
        double amount;
        cout << "Enter the amount to withdraw: Rs. ";
        cin >> amount;
        if (amount > balance)
        {
            cout << "Insufficient balance." << endl;
        }
        else if (amount <= 0)
        {
            cout << "Invalid amount." << endl;
        }
        else
        {
            balance -= amount;
            cout << "Amount Rs. " << amount << " withdrawn successfully." << endl;
        }
    }
    void displayDetails()
    {
        cout << "\nAccount Holder Name: " << name << endl;
        cout << "Account Number: " << accno << endl;
        cout << "Account Type: " << type << endl;
        cout << "Current Balance: Rs. " << balance << endl;
    }
};

int main()
{
    BankAcc account;
    int choice;
    account.initialize();
    do
    {
        cout << "\n--- Bank Account Menu ---" << endl;
        cout << "1. Deposit Amount" << endl;
        cout << "2. Withdraw Amount" << endl;
        cout << "3. Display Account Details" << endl;
        cout << "4. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice)
        {
        case 1:
            account.deposit();
            break;
        case 2:
            account.withdraw();
            break;
        case 3:
            account.displayDetails();
            break;
        case 4:
            cout << "Exiting!" << endl;
            break;
        default:
            cout << "Invalid choice!" << endl;
        }
    } while (choice != 4);

    return 0;
}