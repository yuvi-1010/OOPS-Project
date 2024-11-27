package FigPackage;

public class Cone extends Figure {
    private double s;  // Slant height
    private double h;  // Height

    // Constructor to initialize the radius, slant height, and height
    public Cone(double r, double s, double h) {
        this.r = r;
        this.s = s;
        this.h = h;
    }

    // Calculate the area of the cone
    @Override
    public void calcArea() {
        a = (pi * r * s) + (pi * r * r);
    }

    // Calculate the volume of the cone
    @Override
    public void calcVolume() {
        v = (pi * r * r * h) / 3;
    }

    // Display the area of the cone
    @Override
    public void dispArea() {
        System.out.println("Area of the cone: " + a);
    }

    // Display the volume of the cone
    @Override
    public void dispVolume() {
        System.out.println("Volume of the cone: " + v);
    }
}
