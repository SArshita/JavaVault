import java.util.Scanner;
public class PasswordStrengthIndicator {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            int passwordLength = password.length();
            boolean hasUppercase = false;
            boolean hasLowercase = false;
            boolean hasDigit = false;
            boolean hasSpecialChar = false;

            for (char ch : password.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    hasUppercase = true;
                } else if (Character.isLowerCase(ch)) {
                    hasLowercase = true;
                } else if (Character.isDigit(ch)) {
                    hasDigit = true;
                } else {
                    hasSpecialChar = true;
                }
            }

            // Strength assessment
            if (passwordLength > 8 && hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
                System.out.println("Password strength: Strong");
            } else if (passwordLength > 6 && (hasUppercase || hasLowercase) && hasDigit) {
                System.out.println("Password strength: Medium");
            } else {
                System.out.println("Password strength: Weak");
            }

            scanner.close();
        }
}