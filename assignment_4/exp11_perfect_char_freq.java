// Q.11) You have to enter a string and check whether it is a perfect string or not. A perfect string is a string which has occurance of every character only once.
import java.util.*;
public class exp11_perfect_char_freq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the string: ");
        String input = sc.nextLine();
        
        if (isPerfectString(input)) {
            System.out.println("The string is a perfect string.");
        } else {
            System.out.println("The string is not a perfect string.");
        }
        sc.close();
    }
    
    public static boolean isPerfectString(String str) {
        HashSet<Character> charSet = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (!charSet.add(c)) {
                return false;
            }
        }
        return true;
    }
}