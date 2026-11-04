import java.util.Scanner;

public class CCValidator {
    public static void main(String[] args) {
        long ccNumber;
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.print("Please enter a credit card number:");

            if (!input.hasNextLong()) {
                System.out.println("You did not enter a number");
                input.nextLine();
                continue;
            }
            ccNumber = input.nextLong();

            // type cast from long to string.
            String ccNumberString = Long.toString(ccNumber);

            if (ccNumberString.length() < 13 || ccNumberString.length() > 16) {
                System.out.println(ccNumber + " is an invalid credit card number.");
                return;
            }

            // get prefix
            char prefix = ccNumberString.charAt(0);

            switch(prefix) {
                case '4', '5', '3', '6':
                    // If is 3 but 7 does not follow, invalid
                    if (prefix == '3' && ccNumberString.charAt(1) != '7') {
                        System.out.println(ccNumber + " is an invalid credit card number.");
                        return;
                    }
                    int total1 = 0;
                    int total2 = 0;

                    for (int i = ccNumberString.length() - 2; i >= 0; i -= 2) {
                        int modifiedParsedInt = (ccNumberString.charAt(i) - '0') * 2;

                        if (modifiedParsedInt >= 10) {
                            // If at or greater than 10, parse to string again,
                            // Individual numbers will never get multiplied grater than 2
                            String numString = String.valueOf(modifiedParsedInt);
                            char first = numString.charAt(0);
                            char second = numString.charAt(1);

                            total1 += Integer.parseInt(String.valueOf(first)) + Integer.parseInt(String.valueOf(second));

                        } else {
                            total1 += modifiedParsedInt;
                        }
                    }

                    for (int i = ccNumberString.length() - 1; i >= 0; i -= 2) {
                        total2 += (ccNumberString.charAt(i) - '0');
                    }

                    if ((total1 + total2) % 10 != 0) {
                        System.out.println(ccNumber + " is an invalid credit card number.");
                        return;
                    }

                    System.out.println(ccNumber + " is a valid credit card number.");
                    return;

                default:
                    System.out.println(ccNumber + " is an invalid credit card number.");
                    return;

            }

        }

    }
}
