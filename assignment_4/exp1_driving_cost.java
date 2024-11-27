// 1. Create an application that calculate your daily driving cost , so that you can estimate how much money could be saved by car pooling which also has other advantages such as reducing carbon emission and traffic congestion . The application should input the following information and display the user's cost per day of driving to work.
// a) total miles driven per day
// b)cost per gallon of gasoline
// c)average fees per day s
// d)tolls per day
import java.util.*;

public class exp1_driving_cost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the total miles driven per day: ");
        double milesPerDay = sc.nextDouble();

        System.out.print("Enter the cost per gallon of gasoline: ");
        double costPerGallon = sc.nextDouble();

        System.out.print("Enter the average miles per gallon (fuel efficiency): ");
        double milesPerGallon = sc.nextDouble();

        System.out.print("Enter the parking fees per day: ");
        double parkingFeesPerDay = sc.nextDouble();

        System.out.print("Enter the tolls per day: ");
        double tollsPerDay = sc.nextDouble();

        // Calculate the total gasoline cost per day
        double gasolineCostPerDay = (milesPerDay / milesPerGallon) * costPerGallon;

        // Calculate the total daily cost of driving
        double totalCostPerDay = gasolineCostPerDay + parkingFeesPerDay + tollsPerDay;

        // Display the total cost per day
        System.out.printf("\nTotal daily driving cost: $%.2f%n", totalCostPerDay);

        // Calculate potential savings if carpooling
        System.out.print("\nEnter the number of people in the carpool (including yourself): ");
        int numberOfPeople = sc.nextInt();

        if (numberOfPeople > 1) {
            double costPerPerson = totalCostPerDay / numberOfPeople;
            double savings = totalCostPerDay - costPerPerson;
            System.out.printf("Cost per person when carpooling: $%.2f%n", costPerPerson);
            System.out.printf("Potential savings per day by carpooling: $%.2f%n", savings);
        } else {
            System.out.println("Carpooling requires more than one person. No savings calculated.");
        }

        sc.close();
    }
}
