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

            // convert long to String.
            String ccNumberString = Long.toString(ccNumber);

            if (ccNumberString.length() < 13 || ccNumberString.length() > 16) {
                System.out.println(ccNumber + " is an invalid credit card number.");
                return;
            }

            // get prefix
            char prefix = ccNumberString.charAt(0);

            switch(prefix) {
                case '4', '5', '3', '6':
                    // if is 3 but 7 does not follow, invalid.
                    if (prefix == '3' && ccNumberString.charAt(1) != '7') {
                        System.out.println(ccNumber + " is an invalid credit card number.");
                        return;
                    }
                    int total1 = 0;
                    int total2 = 0;

                    for (int i = ccNumberString.length() - 2; i >= 0; i -= 2) {
                        // convert char to int.
                        int modifiedParsedInt = (ccNumberString.charAt(i) - '0') * 2;

                        // if doubling produces two digits, add them together.
                        if (modifiedParsedInt >= 10) {
                            String numString = String.valueOf(modifiedParsedInt);
                            total1 += (numString.charAt(0) - '0') + (numString.charAt(1) - '0');

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
