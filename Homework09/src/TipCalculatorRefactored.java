import java.util.Scanner;

public class TipCalculatorRefactored {
    public static void main(String[] args) {
        int partyMembersCount;
        float tipPercentage;
        double totalBillAmount, totalTipAmount, duesPerPerson;

        Scanner input = new Scanner(System.in);

        // Member Input
        System.out.print("Enter the number of party members: ");
        if (!input.hasNextInt()) {
            System.err.print("You must enter an integer");
            System.exit(1);
        }
        partyMembersCount = input.nextInt();
        if (partyMembersCount < 1) {
            System.err.println("You must enter a positive integer");
            System.exit(1);
        }

        // Total bill amount
        System.out.print("Enter the total bill amount: ");
        if  (!input.hasNextDouble()) {
            System.err.println("You must enter a valid number");
            System.exit(1);
        }
        totalBillAmount = input.nextDouble();
        if (totalBillAmount <= 0) {
            System.err.println("You must enter a positive bill amount");
            System.exit(1);
        }

        // Tip Percentage
        System.out.print("Enter the tip percentage: ");
        if (!input.hasNextFloat()) {
            System.err.print("Please Enter a valid tip percentage");
            System.exit(1);
        }
        tipPercentage = input.nextFloat();

        // Tip Guards
        if (tipPercentage < 0) {
            System.err.println("Please enter a positive tip percentage");
            System.exit(1);
        } else if (tipPercentage == 0) {
            System.out.print("No Tip is to be paid.");
            return;
        }

        // Calculate
        totalTipAmount = (tipPercentage / 100) *  totalBillAmount;

        duesPerPerson = totalTipAmount / partyMembersCount;

        // Output
        System.out.printf("Number of members in the party: %d\n", partyMembersCount);
        System.out.printf("Total bill amount: $%.2f\n", totalBillAmount);
        System.out.printf("The tip percentage is: %.1f%%\n", tipPercentage);
        System.out.printf("Total tip amount: $%.2f\n", totalTipAmount);
        System.out.printf("The tip amount each patron will pay: $%.2f\n", duesPerPerson);
    }
}