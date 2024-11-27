/*Assume that a publishing company markets prints books and digital books (electronic form –
CD’). Create a structure named Publication with data members named title, price, and author’s name. From
the Publication structure, derive two structures named Book and Ebook. The Book structure adds a page
count data member named count, while the Ebook adds data member playing time name time. Each of these
structures must have a member function getDatd() to read structure-specific data from the keyboard and
display data () to output the structure-specific data to the computer screen. Write a program to test these
classes.*/
#include <bits/stdc++.h>
#define ll long long int
using namespace std;

struct Publication
{
    string title;
    int price;
    string author;
    void getDatd()
    {
        cout << "Enter the title of the book: ";
        cin >> title;
        cout << "Enter the price of the book: ";
        cin >> price;
        cout << "Enter the author of the book: ";
        cin >> author;
    }
    void printdatd()
    {
        cout << "Title: " << title << endl;
        cout << "Price: " << price << endl;
        cout << "Author: " << author << endl;
    }
};

struct Book : Publication
{
    int count;
    void getDatd()
    {
        Publication::getDatd();
        cout << "Enter the no of pages in the book: ";
        cin >> count;
    }
    void printdatd()
    {
        Publication::printdatd();
        cout << "Page Count: " << count << endl;
    }
};

struct Ebook : Publication
{
    int time;
    void getDatd()
    {
        Publication::getDatd();
        cout << "Enter the play time of the Ebook: ";
        cin >> time;
    }
    void printdatd()
    {
        Publication::printdatd();
        cout << "Play time: " << time << " minutes." << endl;
    }
};

int main()
{
    struct Book b1;
    struct Ebook eb1;
    cout << "Enter the details of b1: " << endl;
    b1.getDatd();
    cout << "Enter the details of Eb1: " << endl;
    eb1.getDatd();
    cout << "The details of b1 are: " << endl;
    b1.printdatd();
    cout << "The details of eb1 are: " << endl;
    eb1.printdatd();
    return 0;
}