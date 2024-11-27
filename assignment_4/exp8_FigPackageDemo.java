import FigPackage.Cone;
import FigPackage.Cylinder;
import FigPackage.Sphere;

public class exp8_FigPackageDemo {
    public static void main(String[] args) {
        // Create a Cone object
        Cone cone = new Cone(3.0, 5.0, 7.0);
        cone.calcArea();
        cone.calcVolume();
        cone.dispArea();
        cone.dispVolume();

        // Create a Sphere object
        Sphere sphere = new Sphere(4.0);
        sphere.calcArea();
        sphere.calcVolume();
        sphere.dispArea();
        sphere.dispVolume();

        // Create a Cylinder object
        Cylinder cylinder = new Cylinder(3.0, 6.0);
        cylinder.calcArea();
        cylinder.calcVolume();
        cylinder.dispArea();
        cylinder.dispVolume();
    }
}