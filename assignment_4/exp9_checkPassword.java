// 9. We need to write the function to check the password entered is correct or not based on the following conditions.
// a) It must have atleast one lower case character and one digit.
// b) It must not have any Upper case characters and any special characters
// c) length should be b/w 5-12.
// d) It should not have any same immediate patterns like
// abcanan1 : not acceptable coz of an an pattern
// abc11se: not acceptable, coz of pattern 11
// 123sd123 : acceptable, as not immediate pattern
// adfasdsdf : not acceptable, as no digits
// Aasdfasd12: not acceptable, as have uppercase character

public class exp9_checkPassword {

    public static boolean isValidPassword(String password) {
        // Check length condition
        if (password.length() < 5 || password.length() > 12) {
            return false;
        }

        // Flags for conditions
        boolean hasLowercase = false;
        boolean hasDigit = false;

        // Check for invalid characters and ensure it contains at least one lowercase and one digit
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return false; // Password should not have uppercase characters
            }
            if (!Character.isLetterOrDigit(c)) {
                return false; // Password should not have special characters
            }
            if (Character.isLowerCase(c)) {
                hasLowercase = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        // If no lowercase or no digit, the password is invalid
        if (!hasLowercase || !hasDigit) {
            return false;
        }

        // Check for immediate repeated patterns
        if (hasImmediateRepeatedPattern(password)) {
            return false;
        }

        // If all checks are passed, return true
        return true;
    }

    // Helper method to check for immediate repeated patterns
    private static boolean hasImmediateRepeatedPattern(String password) {
        for (int i = 0; i < password.length() - 1; i++) {
            // Compare current character with the next one
            if (password.charAt(i) == password.charAt(i + 1)) {
                return true; // Immediate pattern found
            }
        }
        // Check for any repeated substrings (like "ana", "aba")
        for (int i = 0; i < password.length() - 2; i++) {
            String substr = password.substring(i, i + 2);
            if (password.indexOf(substr, i + 2) == i + 2) {
                return true; // Immediate repeating substring found
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testPasswords = {
            "abcanan1", // not acceptable: repeating pattern "an an"
            "abc11se",  // not acceptable: repeating "11"
            "123sd123", // acceptable
            "adfasdsdf", // not acceptable: no digit
            "Aasdfasd12", // not acceptable: uppercase character
            "abc12d",  // acceptable
            "123aabbcc", // acceptable
            "abcabc123" // acceptable
        };

        for (String password : testPasswords) {
            System.out.println("Password: " + password + " is " + (isValidPassword(password) ? "valid" : "invalid"));
        }
    }
}
