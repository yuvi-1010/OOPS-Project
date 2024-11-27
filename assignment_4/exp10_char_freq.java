// 10. A string is entered like aabcdeaabcjlkjerwlaaabbsadfdsf...
// And you have to print those characters which exceed a given no. n entered by user.
import java.util.*;

public class exp10_char_freq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the string: ");
        String input = sc.nextLine();
        
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        System.out.println("Characters that occur more than " + n + " times:");
        for (HashMap.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > n) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        sc.close();
    }
}