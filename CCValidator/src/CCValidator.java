import java.util.Arrays;
import java.util.Scanner;

public class CCValidator {
    public static void main(String[] args) {
        long ccNumber;
        boolean isValidNumber = false;
        Scanner input = new Scanner(System.in);

        while(!isValidNumber) {
            System.out.print("Please enter a credit card number:");

            if (!input.hasNextLong()) {
                System.out.println("You did not enter a number");
                input.nextLine();
                continue;
            }
            ccNumber = input.nextLong();

            // type cast for string arr.
            String ccNumberString = Long.toString(ccNumber);

            if (ccNumberString.length() < 13 || ccNumberString.length() > 16) {
                System.out.println(ccNumber + " Is not a valid credit card number");
                continue;
            }

            // get prefix
            int prefix = ccNumberString.charAt(0);

            switch(prefix) {
                case '4', '5', '3', '6':
                    // If is 3 but 7 does not follow, invalid
                    if (prefix == '3' && ccNumberString.charAt(1) != '7') {
                        System.out.println(ccNumber + " Is not a valid credit card number");
                        continue;
                    }
                    int total1 = 0;
                    int total2 = 0;

                    for (int i = 0; i < ccNumberString.length(); i += 2) {
                        int modifiedParsedInt = Integer.parseInt(String.valueOf(ccNumberString.charAt(i))) * 2;

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

                    for (int i = 1; i < ccNumberString.length(); i += 2) {
                        total2 += Integer.parseInt(String.valueOf(ccNumberString.charAt(i)));
                    }

                    IO.println(total1);
                    IO.println(total2);

                    if ((total1 + total2) % 10 != 0) {
                        System.out.println(ccNumber + " Is not a valid credit card number");
                        continue;
                    }

                    System.out.println(ccNumber + " Is a valid credit card number");


                    isValidNumber = true;
                    break;

                default:
                    System.out.println(ccNumber + " Is not a valid credit card number");

            }

        }

    }
}
