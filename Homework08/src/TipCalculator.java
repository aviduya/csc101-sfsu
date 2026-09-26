import java.util.Scanner;

public class TipCalculator {
    public static void main(String[] args) {

        int partyMembersCount;
        double totalTipAmount;

        Scanner input = new Scanner(System.in);

        // Total Member Input
        System.out.print("Enter the number of party members: ");
        if (!input.hasNextInt()) {
            System.err.print("Please enter a valid number");
            System.exit(1);
        }
        partyMembersCount = input.nextInt();

        // Total Bill Amount
        System.out.print("Enter the total bill amount: ");
        if (!input.hasNextDouble()) {
            System.err.print("Please Enter a valid bill amount");
            System.exit(1);
        }
        totalTipAmount = input.nextDouble();

        if (totalTipAmount < 0 || partyMembersCount <= 0 ) {
            System.err.print("Please look at values entered");
            System.exit(1);
        }

        double duesPerPerson = totalTipAmount / partyMembersCount;

        System.out.printf("%-17s : %7d\n", "Number of Members", partyMembersCount);
        System.out.printf("%-17s : %7.2f\n", "Total Tip amount", totalTipAmount);
        System.out.printf("%-17s : %7.2f", "Tip Per Member", duesPerPerson);

    }
}
