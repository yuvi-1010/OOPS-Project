// Experiment 7: Write C++ program to calculate area of a cuboid. Convert the cuboid into a cube using a friend class.
#include <bits/stdc++.h>
#define ll long long int
using namespace std;

// Forward declaration of the Cube class
class Cube;

class Cuboid
{
private:
    double length;
    double width;
    double height;

public:
    // Constructor
    Cuboid(double l, double w, double h) : length(l), width(w), height(h) {}

    double calculateArea() const
    {
        return 2 * (length * width + width * height + height * length);
    }

    void displayDimensions() const
    {
        cout << "Cuboid Dimensions - Length: " << length << ", Width: " << width << ", Height: " << height << endl;
    }

    // Friend class declaration
    friend class Cube;
};

class Cube
{
private:
    double side;

public:
    void convertToCube(const Cuboid &cuboid)
    {
        // Calculate the side of the cube based on the volume of the cuboid
        side = cbrt(cuboid.length * cuboid.width * cuboid.height);
    }

    double calculateArea() const
    {
        return 6 * (side * side);
    }

    void displayDimensions() const
    {
        cout << "Cube Dimensions - Side: " << side << endl;
    }
};

int main()
{
    double length, width, height;

    cout << "Enter the dimensions of the cuboid:" << endl;
    cout << "Length: ";
    cin >> length;
    cout << "Width: ";
    cin >> width;
    cout << "Height: ";
    cin >> height;

    Cuboid cuboid(length, width, height);
    cuboid.displayDimensions();
    cout << "Surface Area of the Cuboid: " << cuboid.calculateArea() << endl;

    Cube cube;
    cube.convertToCube(cuboid);
    cube.displayDimensions();
    cout << "Surface Area of the Cube: " << cube.calculateArea() << endl;

    return 0;
}