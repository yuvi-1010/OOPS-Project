// 2. Create a class called invoice that hardware store might use to represent an invoice for an item sold at the store. An invoice should include four pieces of information as instance variable
//     a part number(type string)
//     a part description(type string)
//     a quantity of the item being purchased(type int)
//     a price per item(double)

import java.util.*;

class Input {
   String number;
   String description;
   int quantity;
   double price;

    Input() {
       number="";
       description="";
       quantity=0;
       price=0.0;
    }

    void set() {
        Scanner sc = new Scanner(System.in);

        System.out.print("number: ");
        number = sc.nextLine();

        System.out.print("description: ");
        description = sc.nextLine();

        System.out.print("Enter quantity: ");
        quantity = sc.nextInt();

        System.out.print("Enter price: ");
        price = sc.nextDouble();
        
        sc.close();
    }
    void get() {
    	System.out.println("number: "+number);
    	System.out.println("description: "+description);
    	System.out.println("quantity: "+quantity);
    	System.out.println("price: "+price);
    }
    void calculate() {
    	if(quantity<0) quantity=0;
    	if (price<0.0) price=0.0;
    	double amount=quantity*price;
    	System.out.print("total amount: "+amount);
    }
}

public class exp2_invoice {
	public static void main(String[] args) {
		Input A=new Input();
		A.set();
		A.get();
		A.calculate();		
	}
}