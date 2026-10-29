import java.util.Scanner;

public class Problems {
    public void runq12() {
        double principal, rate, time, interest;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter principle amount: ");
        principal = input.nextDouble();
        System.out.print("Enter rate of interest (in %): ");
        rate = input.nextDouble();
        System.out.print("Enter the time period (in years): ");
        time = input.nextDouble();

        double simpleInterest = (principal * rate * time) / 100.0;
        double totalWithInterest = simpleInterest + principal;

        System.out.printf("The simple interest is $%.2f\n", simpleInterest);
        System.out.printf("The total amount after interest is: $%.2f", totalWithInterest);

    }

    public void runq11() {
        double balance = 1000;
        int choice;
        double amount = 0.0;

        Scanner in = new Scanner(System.in);
        System.out.print("Current balance: $" + balance + "\n");
        System.out.print("Press 1 to withdraw or 2 to deposit: ");
        choice = in.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Please enter amount to withdraw: $");
                balance -= in.nextDouble();
                break;
            case 2:
                System.out.print("Please enter amount to Deposit: $");
                balance += in.nextDouble();
                break;
            default:
                System.out.print("Invalid Choice, try again.");
                break;
        }
        System.out.printf("Transaction Successful. Your new balance is: $%.2f\n", balance);


    }

    public void run10() {
        Scanner in = new Scanner(System.in);
        final double TIER1 = 0.10;
        final double TIER2 = 0.15;
        final double TIER3 = 0.20;
        int consumption = 0;
        double totalDue = 0.0;

        System.out.print("Please enter your consumption: ");
        consumption = in.nextInt();

        if (consumption <= 100) {
            totalDue = consumption * TIER1;
        } else if (consumption > 101 && consumption <= 300) {
            totalDue = consumption * TIER2;
        } else if (consumption > 300) {
            totalDue = consumption * TIER3;
        }

        System.out.printf("Total bill due: $%.2f", totalDue);

    }


}
