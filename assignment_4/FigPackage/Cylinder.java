package FigPackage;

public class Cylinder extends Figure {
    private double h;  // Height

    // Constructor to initialize the radius and height
    public Cylinder(double r, double h) {
        this.r = r;
        this.h = h;
    }

    // Calculate the area of the cylinder
    @Override
    public void calcArea() {
        a = (2 * pi * r * r) + (2 * pi * r * h);
    }

    // Calculate the volume of the cylinder
    @Override
    public void calcVolume() {
        v = pi * r * r * h;
    }

    // Display the area of the cylinder
    @Override
    public void dispArea() {
        System.out.println("Area of the cylinder: " + a);
    }

    // Display the volume of the cylinder
    @Override
    public void dispVolume() {
        System.out.println("Volume of the cylinder: " + v);
    }
}
