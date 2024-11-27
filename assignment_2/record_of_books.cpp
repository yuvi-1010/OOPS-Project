// 10. Write menu-driven program that keeps a record of books and journals available in the library.
#include <bits/stdc++.h>
using namespace std;

class LibraryItem
{
protected:
    string title;
    string author;
    string publication;

public:
    LibraryItem(string title, string author, string publication)
        : title(title), author(author), publication(publication) {}

    virtual void displayDetails() const = 0;
    virtual ~LibraryItem() {}
};

class Book : public LibraryItem
{
private:
    int pages;

public:
    Book(string title, string author, string publication, int pages)
        : LibraryItem(title, author, publication), pages(pages) {}

    void displayDetails() const override
    {
        cout << "Book Title: " << title << endl;
        cout << "Author: " << author << endl;
        cout << "Publication: " << publication << endl;
        cout << "Pages: " << pages << endl;
    }
};

class Journal : public LibraryItem
{
private:
    int volume;
    int issue;

public:
    Journal(string title, string author, string publication, int volume, int issue)
        : LibraryItem(title, author, publication), volume(volume), issue(issue) {}

    void displayDetails() const override
    {
        cout << "Journal Title: " << title << endl;
        cout << "Author: " << author << endl;
        cout << "Publication: " << publication << endl;
        cout << "Volume: " << volume << endl;
        cout << "Issue: " << issue << endl;
    }
};

class Library
{
private:
    vector<LibraryItem *> items;

public:
    ~Library()
    {
        for (auto item : items)
        {
            delete item;
        }
    }

    void addBook()
    {
        string title, author, publication;
        int pages;
        cout << "Enter Book Title: ";
        cin.ignore();
        getline(cin, title);
        cout << "Enter Author: ";
        getline(cin, author);
        cout << "Enter Publication: ";
        getline(cin, publication);
        cout << "Enter Number of Pages: ";
        cin >> pages;

        items.push_back(new Book(title, author, publication, pages));
        cout << "Book added successfully!" << endl;
    }

    void addJournal()
    {
        string title, author, publication;
        int volume, issue;
        cout << "Enter Journal Title: ";
        cin.ignore();
        getline(cin, title);
        cout << "Enter Author: ";
        getline(cin, author);
        cout << "Enter Publication: ";
        getline(cin, publication);
        cout << "Enter Volume: ";
        cin >> volume;
        cout << "Enter Issue: ";
        cin >> issue;

        items.push_back(new Journal(title, author, publication, volume, issue));
        cout << "Journal added successfully!" << endl;
    }

    void displayAllItems() const
    {
        if (items.empty())
        {
            cout << "No items in the library." << endl;
            return;
        }

        for (const auto &item : items)
        {
            item->displayDetails();
            cout << "-------------------------" << endl;
        }
    }
};

int main()
{
    Library library;
    int choice;

    while (true)
    {
        cout << "\nLibrary Menu:" << endl;
        cout << "1. Add Book" << endl;
        cout << "2. Add Journal" << endl;
        cout << "3. Display All Items" << endl;
        cout << "4. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice)
        {
        case 1:
            library.addBook();
            break;
        case 2:
            library.addJournal();
            break;
        case 3:
            library.displayAllItems();
            break;
        case 4:
            cout << "Exiting..." << endl;
            return 0;
        default:
            cout << "Invalid choice. Please try again." << endl;
        }
    }
}