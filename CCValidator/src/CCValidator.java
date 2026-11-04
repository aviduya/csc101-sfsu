import java.util.Arrays;
import java.util.Scanner;

public class CCValidator {
    public static void main(String[] args) {
        long ccNumber;
        boolean isValidNumber = false;
        Scanner input = new Scanner(System.in);
        int[] ccNumberArr = new int[16];

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

            for (int i = 0; i < ccNumberString.length(); i++) {
                char ch = ccNumberString.charAt(i);
                ccNumberArr[i] = Integer.parseInt(String.valueOf(ch));
            }

            // get prefix
            int prefix = ccNumberArr[0];

            switch(prefix) {
                case 4, 5, 3, 6:
                    // If is 3 but 7 does not follow, invalid
                    if (prefix == 3 && ccNumberArr[1] != 7) {
                        System.out.println(ccNumber + " Is not a valid credit card number");
                        continue;
                    }
                    int total1 = 0;


                    for (int i = 0; i < ccNumberArr.length; i += 2) {
                        IO.println(ccNumberArr[i]);
                        if (ccNumberArr[i] * 2 > 10) {
                            int result = ccNumberArr[i] * 2;
                            Integer.toString()

                        } else {
                            total1 += ccNumberArr[i];
                        }

                    }


                    isValidNumber = true;
                    break;

                default:
                    System.out.println(ccNumber + " Is not a valid credit card number");

            }

        }

    }
}
