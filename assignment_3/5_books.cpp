// Assume that a publishing company markets prints books and digital books (electronic form – CD’). Create a class named Publication with data members named title, price, and author’s name. From Publication class, derive two classes named Book and Ebook. The Book class adds a page count data member named pcount while Ebook adds data member playing time name ptime. Each of these classes must have member function getDatd() to read class specific data from keyboard and displayData() to output the class specific data to the computer screen. Write a program to test these classes.

#include <bits/stdc++.h>
#define ll long long int
using namespace std;

class Publication
{
protected:
    string title;
    double price;
    string authorName;

public:
    void getData()
    {
        cout << "Enter the title: ";
        getline(cin, title);
        cout << "Enter the author's name: ";
        getline(cin, authorName);
        cout << "Enter the price: Rs. ";
        cin >> price;
        cin.ignore();
    }
    void displayData()
    {
        cout << "\nTitle: " << title << endl;
        cout << "Author: " << authorName << endl;
        cout << "Price: Rs. " << price << endl;
    }
};

class Book : public Publication
{
private:
    int pageCount;

public:
    void getData()
    {
        Publication::getData();
        cout << "Enter the page count: ";
        cin >> pageCount;
        cin.ignore();
    }

    void displayData()
    {
        Publication::displayData();
        cout << "Page Count: " << pageCount << endl;
    }
};

class Ebook : public Publication
{
private:
    double playingTime;

public:
    void getData()
    {
        Publication::getData();
        cout << "Enter the playing time (in hours): ";
        cin >> playingTime;
        cin.ignore();
    }

    void displayData()
    {
        Publication::displayData();
        cout << "Playing Time: " << playingTime << " hours" << endl;
    }
};

int main()
{
    Book book;
    Ebook ebook;
    cout << "--- Enter details for a printed book ---" << endl;
    book.getData();
    cout << "\n--- Enter details for an ebook ---" << endl;
    ebook.getData();

    cout << "\n--- Details of the printed book ---" << endl;
    book.displayData();
    cout << "\n--- Details of the ebook ---" << endl;
    ebook.displayData();

    return 0;
}