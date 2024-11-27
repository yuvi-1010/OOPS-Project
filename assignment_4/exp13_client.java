// 13.Declare an interface called Function that has a method named evaluate that takes an int parameter and returns an int value.Create a class Half that implements Function. Make the implementation of the method evaluate() return the value obtained by dividing the int argument by 2.In a client, create a method that takes an arbitrary array of int values as parameter and returns an array that has the same length, but the value of an element in the new array is half that of the value in the corresponding element in the array passed as parameter. Let the implementation of this method create an instance of Half and use this instance to calculate the values in the array to be returned.

import java.util.*;

interface Function {
    int evaluate(int x);
}

class Half implements Function {
    @Override
    public int evaluate(int x) {
        return x / 2;
    }
}

public class exp13_client {
    // Method to process the array and return an array with halved values
    public static int[] processArray(int[] array) {
        Function halfFunction = new Half();
        
        int[] resultArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            resultArray[i] = halfFunction.evaluate(array[i]);
        }

        return resultArray;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] originalArray = new int[n];
        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            originalArray[i] = sc.nextInt();
        }

        int[] halfArray = processArray(originalArray);

        System.out.println("Original array: " + Arrays.toString(originalArray));
        System.out.println("Half array: " + Arrays.toString(halfArray));

        sc.close();
    }
}