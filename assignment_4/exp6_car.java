// Q6) Write a function Model-of-Category for a Tata motor dealers, which accepts category of car customer is looking for and returns the car Model available in that category. the function should accept the following categories “SUV”, “SEDAN”, “ECONOMY”, and “MINI” which in turn returns “TATA SAFARI” , “TATA INDIGO” , “TATA INDICA” and “TATA NANO” respectively.

import java.util.*;
public class exp6_car {
    public static String modelOfCategory(String category) {
        category = category.toUpperCase();

        switch (category) {
            case "SUV":
                return "TATA SAFARI";
            case "SEDAN":
                return "TATA INDIGO";
            case "ECONOMY":
                return "TATA INDICA";
            case "MINI":
                return "TATA NANO";
            default:
                return "Invalid category. Please choose from SUV, SEDAN, ECONOMY, or MINI.";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the category of car (SUV, SEDAN, ECONOMY, MINI): ");
        String category = sc.nextLine();

        String model = modelOfCategory(category);
        System.out.println("Car model: " + model);

        sc.close();
    }
}