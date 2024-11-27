// Create a class called date that include three instance variable a) month(type int) b)day (type int) and c) year (type int) . provide a constructer that initialize a three instance variable and assume the value provided are correct. Provide a set and a get method for each instance variable.Provide a method DisplayDate that display the month year and day separated by forward slashand write a test application named DateTest that demonstrate date capabilities.

import java.util.*;

class Date {
	int month;
    int day;
    int year;

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayDate() {
        System.out.printf("%02d/%02d/%d%n", month, day, year);
    }
}

public class exp4_displayDate {
    public static void main(String[] args) {
        Date date1 = new Date(06, 24, 2005);
        System.out.print("The date is: ");
        date1.displayDate();

        date1.setMonth(11);
        date1.setDay(27);
        date1.setYear(1982);

        System.out.print("The updated date is: ");
        date1.displayDate();
    }
}