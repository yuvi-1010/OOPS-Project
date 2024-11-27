// 5. (Gas mileage) Drivers are concerned with the mileage theit automobiles get. One driver has kept track of several trips by recording the miles driven and gallons used for each tankful.Develop a java application that will input the miles driven and gallons used(both as in) for each trip.The program should calculate and display the miles per gallon obtained for each trip and print the combined miles per gallon obtained for all trips up to this point. All averaging calculate should produce floating point results. Use class scanner and sentinel-controlled repetition to obtain the data from the user.

import java.util.*;

public class exp5_mileage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int milesDriven;
        int gallonsUsed;
        int totalMiles = 0;
        int totalGallons = 0;
        int sentinel = -1;

        System.out.print("Enter miles driven (-1 to quit): ");
        milesDriven = sc.nextInt();

        // Loop to process each trip
        while (milesDriven != sentinel) {
            System.out.print("Enter gallons used: ");
            gallonsUsed = sc.nextInt();

            // Calculate and display miles per gallon for the current trip
            if (gallonsUsed != 0) {
                double milesPerGallon = (double) milesDriven / gallonsUsed;
                System.out.printf("Miles per gallon for this trip: %.2f%n", milesPerGallon);
            } else {
                System.out.println("Gallons cannot be zero.");
            }

            // Update the total miles and total gallons
            totalMiles += milesDriven;
            totalGallons += gallonsUsed;

            // Prompt for the next trip
            System.out.print("Enter miles driven (-1 to quit): ");
            milesDriven = sc.nextInt();
        }

        // Check if total gallons is non-zero to calculate the combined MPG
        if (totalGallons != 0) {
            double combinedMilesPerGallon = (double) totalMiles / totalGallons;
            System.out.printf("Combined miles per gallon for all trips: %.2f%n", combinedMilesPerGallon);
        } else {
            System.out.println("No trips entered.");
        }

        sc.close();
    }
}