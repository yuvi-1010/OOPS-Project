// 9. Use OOP’s concept based program to display the cheapest book available on a subject.
#include <bits/stdc++.h>
using namespace std;

class Book
{
private:
    string title;
    string author;
    string subject;
    double price;

public:
    Book(string t, string a, string s, double p) : title(t), author(a), subject(s), price(p) {}

    string getSubject() const
    {
        return subject;
    }

    double getPrice() const
    {
        return price;
    }

    void display() const
    {
        cout << "Title: " << title << endl;
        cout << "Author: " << author << endl;
        cout << "Subject: " << subject << endl;
        cout << "Price: " << price << endl;
    }
};

class Library
{
private:
    vector<Book> books;

public:
    void addBook(const Book &book)
    {
        books.push_back(book);
    }

    void displayCheapestBook(const string &subject) const
    {
        double minPrice = numeric_limits<double>::max();
        const Book *cheapestBook = nullptr;

        for (const auto &book : books)
        {
            if (book.getSubject() == subject && book.getPrice() < minPrice)
            {
                minPrice = book.getPrice();
                cheapestBook = &book;
            }
        }

        if (cheapestBook)
        {
            cout << "Cheapest book on " << subject << ":" << endl;
            cheapestBook->display();
        }
        else
        {
            cout << "No books found on the subject: " << subject << endl;
        }
    }
};

int main()
{
    Library library;
    int numBooks;

    cout << "Enter the number of books: ";
    cin >> numBooks;
    cin.ignore();

    for (int i = 0; i < numBooks; ++i)
    {
        string title, author, subject;
        double price;

        cout << "Enter title of book " << i + 1 << ": ";
        getline(cin, title);
        cout << "Enter author of book " << i + 1 << ": ";
        getline(cin, author);
        cout << "Enter subject of book " << i + 1 << ": ";
        getline(cin, subject);
        cout << "Enter price of book " << i + 1 << ": ";
        cin >> price;
        cin.ignore();

        library.addBook(Book(title, author, subject, price));
    }

    cout << "Enter subject to find the cheapest book: ";
    string searchSubject;
    getline(cin, searchSubject);

    library.displayCheapestBook(searchSubject);

    return 0;
}